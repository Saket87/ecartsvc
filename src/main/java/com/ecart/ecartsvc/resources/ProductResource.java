package com.ecart.ecartsvc.resources;


import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ecart.ecartsvc.model.Product;
import com.ecart.ecartsvc.service.ProductService;

@Path("/api")
public class ProductResource {
	
	@Inject
	ProductService productservice;
	
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveProducts() {
				
		List<Product> products =  productservice.retrieveProducts();
        
		return products;
	}
	
	@GET
	@Path("/products-by-category")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveProductByCategory(@QueryParam("category") String category, @QueryParam("price") BigDecimal price) {
			
		List<Product> products =  productservice.retrieveProductByCategory(category, price);
        
		return products;
	}
	
	@GET
	@Path("/products-by-company")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveProductByCompany(@QueryParam("company") String company, @QueryParam("price") BigDecimal price) {
			
		List<Product> products =  productservice.retrieveProductByCompany(company, price);
        
		return products;
	}
	
	@GET
	@Path("/discount-products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveDiscountProduct(@QueryParam("category") String category) {
				
		List<Product> products =  productservice.retrieveDiscountedProducts(category);
        
		return products;
	}
	
}
