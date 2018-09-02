import com.jwebmp.core.services.IPage;
import com.jwebmp.examples.undertow.helloworld.HelloWorld;
import com.jwebmp.examples.undertow.helloworld.HelloWorldCSS;
import com.jwebmp.examples.undertow.helloworld.HelloWorldCSSObject;
import com.jwebmp.examples.undertow.helloworld.HelloWorldPlain;

module com.jwebmp.examples.undertow.helloworld {

	exports com.jwebmp.examples.undertow.helloworld to com.google.guice;

	requires javax.servlet.api;
	requires java.logging;

	requires undertow.core;
	requires undertow.servlet;

	requires com.jwebmp.guicedinjection;
	requires com.jwebmp.logmaster;
	requires com.jwebmp.core;
	requires com.google.guice.extensions.servlet;
	requires com.jwebmp.undertow;

	provides IPage with HelloWorld, HelloWorldCSS, HelloWorldCSSObject, HelloWorldPlain;
}
