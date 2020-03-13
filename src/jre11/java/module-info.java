module com.jwebmp.examples.undertow.helloworld {

	exports com.jwebmp.examples.undertow.helloworld to com.google.guice;

	requires javax.servlet.api;
	requires java.logging;



	requires undertow.core;
	requires undertow.servlet;

	requires com.jwebmp.core;
	requires com.guicedee.guicedservlets.undertow;

	provides com.jwebmp.core.services.IPage with com.jwebmp.examples.undertow.helloworld.HelloWorld;
			                                        /*,
			                                        com.jwebmp.examples.undertow.helloworld.HelloWorldCSS,
			                                        com.jwebmp.examples.undertow.helloworld.HelloWorldCSSObject,
			                                        com.jwebmp.examples.undertow.helloworld.HelloWorldPlain;*/
	opens com.jwebmp.examples.undertow.helloworld to com.google.guice;
}
