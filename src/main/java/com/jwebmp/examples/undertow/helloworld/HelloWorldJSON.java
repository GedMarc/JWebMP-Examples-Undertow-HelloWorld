package com.jwebmp.examples.undertow.helloworld;

import com.jwebmp.core.Page;
import com.jwebmp.core.annotations.PageConfiguration;

@PageConfiguration(url = "/jsontest",
		ignore = true)
public class HelloWorldJSON
		extends Page
{
	public HelloWorldJSON()
	{
		super();
		getOptions().setAuthor("GedMarc");
		getOptions().setKeywords("Some Random Keywords");
	}

	public static void main(String[] args)
	{
		System.out.println(new HelloWorldJSON().toString());
	}
}
