package com.ecart.ecartsvc.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.ecart.ecartsvc.service.OrderService;
import com.ecart.ecartsvc.service.ProductService;

@ApplicationPath("/")
public class AppResourceConfig extends ResourceConfig {
	
	public AppResourceConfig() {
		packages("com.ecart.ecartsvc.resources");
		
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		
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
