package com.jwebmp.examples.undertow.helloworld;

import com.jwebmp.core.Page;
import com.jwebmp.core.annotations.PageConfiguration;
import com.jwebmp.core.base.html.H3;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundBlendMode;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundCSS;
import com.jwebmp.core.htmlbuilder.css.borders.BorderCSS;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.composer.CSSComposer;
import com.jwebmp.core.htmlbuilder.css.displays.DisplayCSS;
import com.jwebmp.core.htmlbuilder.css.displays.Displays;
import com.jwebmp.core.htmlbuilder.css.enumarations.BorderStyles;
import com.jwebmp.core.htmlbuilder.css.fonts.FontStyles;
import com.jwebmp.core.htmlbuilder.css.fonts.FontsCSS;
import com.jwebmp.core.htmlbuilder.css.image.ImageCSS;
import com.jwebmp.core.htmlbuilder.css.text.TextAlignments;
import com.jwebmp.core.htmlbuilder.css.text.TextCSS;
import com.jwebmp.logger.logging.LogColourFormatter;

@PageConfiguration(url = "/jscss")
public class HelloWorldCSS
		extends Page
{
	/**
	 * The CSS Engine is grouped according to the W3Schools Docs - https://www.w3schools.com/css/default.asp
	 */
	@FontsCSS(FontStyle = FontStyles.Italic)
	@TextCSS(Color$ = ColourNames.DarkBlue,
			TextAlign = TextAlignments.Center)
	private Span<?, ?, ?> fieldExample;

	@BackgroundCSS(BackgroundImage = @ImageCSS("url/image.png"))
	private Span<?, ?, ?> separateDeclarationsFieldExample;

	@BorderCSS(BorderBottomStyle = BorderStyles.Dotted)
	private Span<?, ?, ?> hoverOverFieldExample;

	@DisplayCSS(Display = Displays.Flex)
	private Span<?, ?, ?> nullFieldIgnoredExampleNoIDAvailable;

	public HelloWorldCSS()
	{
		super();
		fieldExample = new Span<>();
		separateDeclarationsFieldExample = new Span<>();
		hoverOverFieldExample = new Span<>();

		getBody().add("Something that is not an annotated span");

		H3 inline = new H3("Inline?");
		inline.getCss()
		      .getBackground()
		      .setBackgroundBlendMode(BackgroundBlendMode.Darken);
		getBody().add(inline);

		getBody().addAttribute("style", "color:inner");
		getBody().addStyle("method2", "value2");
		getBody().addStyle("method3:value3");
	}

	public static void main(String[] args)
	{
		HelloWorldCSS page = new HelloWorldCSS();
		LogColourFormatter.setRenderBlack(false);

		//Directly render the CSS from the Composer
		CSSComposer comp = new CSSComposer();
		comp.addComponent(page, true);
		System.out.println(comp.toString());
		System.out.println("----------------- HTML --------------------");
		System.out.println(page.toString(0));
		System.out.println("----------------- CSS ---------------------");
		System.out.println(page.renderCss(0));
	}
}
