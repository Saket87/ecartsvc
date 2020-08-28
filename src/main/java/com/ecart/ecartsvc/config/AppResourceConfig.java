package com.ecart.ecartsvc.config;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.ecart.ecartsvc.service.OrderService;
import com.ecart.ecartsvc.service.ProductService;

@ApplicationPath("/")
public class AppResourceConfig extends ResourceConfig {
	
	public AppResourceConfig() {
		packages("com.ecart.ecartsvc.resources");
		
		register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindAsContract(OrderService.class).in(Singleton.class);
            }
        });
		
		register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindAsContract(ProductService.class).in(Singleton.class);
            }
        });
		
	}
}
