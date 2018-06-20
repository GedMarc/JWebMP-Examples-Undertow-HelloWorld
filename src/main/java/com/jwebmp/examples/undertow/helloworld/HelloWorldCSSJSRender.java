package com.jwebmp.examples.undertow.helloworld;

import com.jwebmp.CSSComponent;
import com.jwebmp.Feature;

public class HelloWorldCSSJSRender
		extends CSSComponent
{
	/**
	 * Constructs a new CSS Class with the given features and events associated
	 * <p>
	 *
	 * @param className
	 */
	public HelloWorldCSSJSRender(String className)
	{
		super(className);
		addFeature(new Feature("CSSFeature")
		{
			@Override
			protected void assignFunctionsToComponent()
			{
				addQuery(getComponent().getJQueryID() + "css('color','blue');");
			}
		});
	}
}
