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
	
	
	/**
	 * 1. Get the list of all the products across all the categories
	 * 2. Get the available stock details across products. This should consider the dummy orders placed and return stocks accordingly. 
	 * 
	 * @return
	 */
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveProducts() {
				
		List<Product> products =  productservice.retrieveProducts();
        
		return products;
	}
	
	
	/**
	 * Get the list of all the products by category or of a price less than or greater than a specified price for that product
	 * @param category
	 * @param price
	 * @return
	 */
	@GET
	@Path("/products-by-category")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveProductByCategory(@QueryParam("category") String category, @QueryParam("price") BigDecimal price) {
			
		List<Product> products =  productservice.retrieveProductByCategory(category, price);
        
		return products;
	}
	
	
	/**
	 * Get the list of all the products by company or of a price less than or greater than a specified price for that company
	 * @param company
	 * @param price
	 * @return
	 */
	@GET
	@Path("/products-by-company")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveProductByCompany(@QueryParam("company") String company, @QueryParam("price") BigDecimal price) {
			
		List<Product> products =  productservice.retrieveProductByCompany(company, price);
        
		return products;
	}
	
	/**
	 * Get the discounted price of all the products by category
	 * @param category
	 * @return
	 */
	@GET
	@Path("/discount-products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveDiscountProduct(@QueryParam("category") String category) {
				
		List<Product> products =  productservice.retrieveDiscountedProducts(category);
        
		return products;
	}
	
}
