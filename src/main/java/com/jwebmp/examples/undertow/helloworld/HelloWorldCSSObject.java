package com.jwebmp.examples.undertow.helloworld;


import com.jwebmp.Page;
import com.jwebmp.annotations.PageConfiguration;
import com.jwebmp.base.html.Paragraph;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.logger.logging.LogColourFormatter;

import java.util.logging.Level;

@PageConfiguration(url = "/jscssobj")
public class HelloWorldCSSObject
		extends Page
{
	public HelloWorldCSSObject()
	{
		super();
		add(new HelloWorldCSSJSRender("cssClassName"));
		add(new Paragraph("Hello World"));
		getOptions().setDynamicRender(false);
	}

	public static void main(String[] args)
	{
		LogFactory.configureConsoleColourOutput(Level.FINE);
		LogColourFormatter.setRenderBlack(false);
		HelloWorldCSSObject page = new HelloWorldCSSObject();
		System.out.println(page.toString(0));
		System.out.println(page.renderJavascript());
	}

}
