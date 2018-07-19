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
}
