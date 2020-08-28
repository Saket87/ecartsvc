package com.ecart.ecartsvc.service;

import java.math.BigDecimal;
import java.util.List;

import com.ecart.ecartsvc.config.JdbiConfig;
import com.ecart.ecartsvc.dao.ProductDao;
import com.ecart.ecartsvc.model.Product;


public class ProductService{
	
	/**
	 * 1. Get the list of all the products across all the categories
	 * 2. Get the available stock details across products. This should consider the dummy orders placed and return stocks accordingly. 
	 * 
	 * @return
	 */
	public List<Product> retrieveProducts() {
				
		List<Product> products =  JdbiConfig.getJdbi().withExtension(ProductDao.class, dao -> {
            return dao.listProducts();
			});
        
		return products;
	}
	
	/**
	 * Get the list of all the products by category or of a price less than or greater than a specified price for that product
	 * @param category
	 * @param price
	 * @return
	 */
	public List<Product> retrieveProductByCategory(String category, BigDecimal price) {
			
		List<Product> products;
				
		if(null==price) {
			
			products =  JdbiConfig.getJdbi().withExtension(ProductDao.class, dao -> {
	            return dao.listProductsByCategory(category);
				});
		}else {
			
			products =  JdbiConfig.getJdbi().withExtension(ProductDao.class, dao -> {
	            return dao.listProductsByCategory(category, price);
				});
		}
 
        
		return products;
	}
	
	/**
	 * Get the list of all the products by company or of a price less than or greater than a specified price for that company
	 * @param company
	 * @param price
	 * @return
	 */
	public List<Product> retrieveProductByCompany(String company, BigDecimal price) {
			
		List<Product> products;
		
		if(null==price) {
			
			products = JdbiConfig.getJdbi().withExtension(ProductDao.class, dao -> {
	            return dao.listProductsByCompany(company);
				});
		}else {
			
			products = JdbiConfig.getJdbi().withExtension(ProductDao.class, dao -> {
	            return dao.listProductsByCompany(company, price);
				});
			
		}
        
		return products;
	}
	
	/**
	 * Get the discounted price of all the products by category
	 * @param category
	 * @return
	 */
	public List<Product> retrieveDiscountedProducts(String category) {
				
		List<Product> products =  JdbiConfig.getJdbi().withExtension(ProductDao.class, dao -> {
            return dao.listDiscountedProductsByCategory(category);
			});
        
		return products;
	}
	
	/**
	 * Get list products by product code
	 * @param category
	 * @return
	 */
	public List<Product> retrieveProductByProductcode(String product) {
				
		List<Product> products = JdbiConfig.getJdbi().withExtension(ProductDao.class, dao -> {
            return dao.listProductsByProduct(product);
			});
        
		return products;
	}
	
	
}
  
  