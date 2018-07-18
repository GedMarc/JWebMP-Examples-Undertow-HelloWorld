/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.examples.undertow.helloworld;

import com.jwebmp.Page;
import com.jwebmp.base.html.Paragraph;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainer;

import javax.servlet.ServletException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class HelloWorld
		extends Page
{
	public HelloWorld()
	{
		super("Hello World!");
		add(new Paragraph("Hello World"));
	}

	/**
	 * This part runs the web site :)
	 *
	 * @param args
	 *
	 * @throws ServletException
	 */
	public static void main(String[] args) throws ServletException
	{
		ServletContainer container = io.undertow.servlet.Servlets.defaultContainer();
		DeploymentInfo di = Servlets.deployment()
		                            .setClassLoader(HelloWorld.class.getClassLoader())
		                            .setContextPath("/myApp")
		                            .setDeploymentName("My Application");

		DeploymentManager manager = container.addDeployment(di); //Add the deployment
		manager.deploy(); // Initial Deployment by servlets not started yet.
		HttpHandler handler = manager.start(); // Start the servlet initialization process.

		LogFactory.setLogToConsole(true);
		LogFactory.getInstance()
		          .addLogHandler(new ConsoleHandler());
		LogFactory.configureConsoleColourOutput(Level.FINE);

		DeploymentInfo servletBuilder = Servlets.deployment()
		                                        .setContextPath("/")
		                                        .setDeploymentName("helloworld.war");

		DeploymentManager manager2 = Servlets.defaultContainer()
		                                    .addDeployment(servletBuilder);

		GuiceContext.inject();
		manager2.deploy();

		HttpHandler jwebSwingHandler = manager2.start();
		Undertow server = Undertow.builder()
		                          .addHttpListener(6002, "localhost")
		                          .setHandler(jwebSwingHandler)
		                          .build();
		server.start();
	}
}
