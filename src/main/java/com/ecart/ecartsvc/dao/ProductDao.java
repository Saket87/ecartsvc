package com.ecart.ecartsvc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.ecart.ecartsvc.model.Product;


public interface ProductDao {

	
    @SqlUpdate("CREATE TABLE product (product VARCHAR PRIMARY KEY, productdescription VARCHAR, color VARCHAR, company VARCHAR, category VARCHAR, stock INTEGER, price NUMERIC, discount NUMERIC)")
    void createTable();

    @SqlUpdate("INSERT INTO product(product, productdescription, color, company, category, stock, price, discount) VALUES (:product, :productdescription, :color, :company, :category, :stock, :price, :discount)")
    void insertBean(@BindBean Product product);

    @SqlQuery("SELECT * FROM product")
    @RegisterBeanMapper(Product.class)
    List<Product> listProducts();
    
    @SqlQuery("SELECT * FROM product WHERE product = ?")
    @RegisterBeanMapper(Product.class)
    List<Product> listProductsByProduct(String product);
    
    @SqlQuery("SELECT * FROM product where category = ?")
    @RegisterBeanMapper(Product.class)
    List<Product> listProductsByCategory(String category);
    
    @SqlQuery("SELECT * FROM product where category = ? and price <> ?")
    @RegisterBeanMapper(Product.class)
    List<Product> listProductsByCategory(String category, BigDecimal price);
    
    @SqlQuery("SELECT * FROM product where company = ?")
    @RegisterBeanMapper(Product.class)
    List<Product> listProductsByCompany(String company);
    
    @SqlQuery("SELECT * FROM product where company = ? and price <> ?")
    @RegisterBeanMapper(Product.class)
    List<Product> listProductsByCompany(String company, BigDecimal price);
    
    @SqlQuery("SELECT product, productdescription, color, company, category, stock, (price - ((price*discount)/100)) as price, discount FROM product where category = ? and discount > 0")
    @RegisterBeanMapper(Product.class)
    List<Product> listDiscountedProductsByCategory(String category);
    
    @SqlUpdate("UPDATE product SET stock = ? WHERE product = ?")
    void updateProduct(Integer stock, String product);

    
}