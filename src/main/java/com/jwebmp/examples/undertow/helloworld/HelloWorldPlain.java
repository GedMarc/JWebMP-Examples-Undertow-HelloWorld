package com.jwebmp.examples.undertow.helloworld;

import com.jwebmp.core.Feature;
import com.jwebmp.core.Page;
import com.jwebmp.core.annotations.PageConfiguration;
import com.jwebmp.core.base.html.H3;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.plugins.jquery.JQueryReferencePool;
import com.jwebmp.logger.LogFactory;

import java.util.logging.Level;

@PageConfiguration(url = "/jstest")
public class HelloWorldPlain
		extends Page
{
	public HelloWorldPlain()
	{
		super("Hello World!");
		Paragraph chb = new Paragraph("Hello World");
		add(chb);
		//Renders the javascript and css in the page instead of different servlets
		getOptions().setDynamicRender(false);
		//Adds a feature (Client Side JS) to the hello world object
		chb.addFeature(new Feature("My Custom Feature", chb)
		{
			@Override
			protected void assignFunctionsToComponent()
			{
				addQuery("alert('Though they are usually added through named plugin features...');");
			}
		});

		addQuery(new StringBuilder("alert('You can add them directly to the component.');" + getNewLine()));

		//This is how to add custom references
		addJavaScriptReference(JQueryReferencePool.JQueryV3.getJavaScriptReference());
		addCssReference(new CSSReference("Custom CSS 1", 1.0, "css/custom.css"));

		//These methods are on every object
		add(new H3<>("This references the JS").addJavaScriptReference(new JavascriptReference("Custom JS", 1.0, "js/custom.js")));
	}

	public static void main(String[] args)
	{
		LogFactory.setDefaultLevel(Level.WARNING);
		System.out.println(new HelloWorldPlain().renderJavascript());
		System.out.println("--------------");
		System.out.println(new HelloWorldPlain().toString(0));
	}
}
