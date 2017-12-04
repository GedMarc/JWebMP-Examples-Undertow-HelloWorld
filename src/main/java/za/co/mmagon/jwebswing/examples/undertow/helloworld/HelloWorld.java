package za.co.mmagon.jwebswing.examples.undertow.helloworld;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

import javax.servlet.ServletException;

public class HelloWorld extends Page
{
	public HelloWorld()
	{
		super("Hello World!");
		add(new Paragraph("Hello World"));

		JQueryPageConfigurator.setRequired(getBody(),true);
		AngularPageConfigurator.setRequired(getBody(),true);
	}

	/**
	 * Not needed at all, but beautiful for post load ajax operations, local storage identifying etc
	 * @param call
	 * @param response
	 * @return
	 */
	@Override
	public AjaxResponse onConnect(AjaxCall<?> call, AjaxResponse response)
	{
		return super.onConnect(call, response);
	}

	/**
	 * This part runs the web site :)
	 * @param args
	 * @throws ServletException
	 */
	public static void main(String[] args) throws ServletException
	{
		DeploymentInfo servletBuilder = Servlets.deployment()
				                                .setClassLoader(HelloWorld.class.getClassLoader())
				                                .setContextPath("/")
				                                .setDeploymentName("helloworld.war");
		DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
		manager.deploy();
		HttpHandler jwebSwingHandler = manager.start();
		Undertow server = Undertow.builder()
				                  .addHttpListener(8080, "localhost")
				                  .setHandler(jwebSwingHandler)
				                  .build();
		server.start();
	}
}
