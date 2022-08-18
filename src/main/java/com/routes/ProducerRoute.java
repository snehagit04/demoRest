package com.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
@Component
public class ProducerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration().component("servlet");
		
		rest("/hello")
		.get()
		.to("direct:RestDemo");
		
		from("direct:RestDemo")
		.transform().constant("Welcome to my first rest api producer class");
		
			
		
	}

}
