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
import za.co.mmagon.logger.LogFactory;

import javax.servlet.ServletException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloWorld extends Page
{
	private static final Logger log = LogFactory.getLog("UndertowHelloWorld");

	public HelloWorld()
	{
		super("Hello World!");
		add(new Paragraph("Hello World"));

		//Enables the onConnect function
		JQueryPageConfigurator.setRequired(getBody(), true);
		AngularPageConfigurator.setRequired(getBody(), true);
	}

	/**
	 * Not needed at all, but beautiful for post load ajax operations, local storage identifying etc
	 *
	 * @param call
	 * 		A request scoped call object
	 * @param response
	 * 		A request scoped response object
	 *
	 * @return
	 */
	@Override
	public AjaxResponse onConnect(AjaxCall<?> call, AjaxResponse response)
	{
		if (call != null)
		{
			log.log(Level.INFO, "This is the call object : {0}", call);
		}
		return super.onConnect(call, response);
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
