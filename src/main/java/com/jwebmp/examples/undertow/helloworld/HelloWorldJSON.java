package com.jwebmp.examples.undertow.helloworld;


import com.jwebmp.Page;
import com.jwebmp.annotations.PageConfiguration;

@PageConfiguration(url = "/jsontest")
public class HelloWorldJSON
		extends Page
{
	public HelloWorldJSON()
	{
		super();
		getPageFields().setAuthor("GedMarc");
		getPageFields().setKeywords("Some Random Keywords");
	}

	public static void main(String[] args)
	{
		System.out.println(new HelloWorldJSON().toString());
	}
}
