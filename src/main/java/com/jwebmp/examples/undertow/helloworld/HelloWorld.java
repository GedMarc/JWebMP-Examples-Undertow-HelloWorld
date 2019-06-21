/*
 * Copyright (C) 2017 GedMarc
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

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.html.Strong;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.logger.logging.LogColourFormatter;
import com.jwebmp.undertow.GuicedUndertow;

import javax.servlet.ServletException;
import java.util.logging.Level;

public class HelloWorld
		extends Page
{
	public HelloWorld()
	{
		super("Hello World!");
		add(new Paragraph("Hello World"));
		add(new Paragraph("Hello World 222"));
		add(new Link<>("Click Here", "_blank").setText("Custom Link"));
		add(new Strong("This is bold"));
	}

	/**
	 * This part runs the web site :)
	 *
	 * @param args
	 *
	 * @throws ServletException
	 */
	public static void main(String[] args) throws Exception
	{
		LogFactory.setLogToConsole(true);
		LogFactory.configureConsoleColourOutput(Level.INFO);
		LogColourFormatter.setRenderBlack(false);
		GuicedUndertow.boot("localhost", 6002);
		LogFactory.getLog("Program")
		          .info("Started");

		//Which is a shortcut for :

		/*
		DeploymentInfo deploymentInfo = Servlets.deployment()
		                                        .setClassLoader(HelloWorld.class.getClassLoader())
		                                        .setContextPath("/")
		                                        .setDeploymentName("helloworld.war");

		DeploymentManager manager2 = Servlets.defaultContainer()
		                                     .addDeployment(deploymentInfo);

		GuiceContext.inject();
		manager2.deploy();

		HttpHandler jwebSwingHandler = manager2.start();
		Undertow server = Undertow.builder()
		                          .addHttpListener(6002, "localhost")
		                          .setHandler(jwebSwingHandler)
		                          .build();
		server.start();
		*/
	}
}
