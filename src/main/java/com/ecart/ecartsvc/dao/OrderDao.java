package com.ecart.ecartsvc.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.ecart.ecartsvc.model.Order;


public interface OrderDao {

	
    @SqlUpdate("CREATE TABLE ordertb (orderid INTEGER PRIMARY KEY, product VARCHAR, quantity INTEGER)")
    void createTable();

    @SqlUpdate("INSERT INTO ordertb(orderid, product, quantity) VALUES (:orderid, :product, :quantity)")
    void insertBean(@BindBean Order order);

    @SqlQuery("SELECT * FROM ordertb")
    @RegisterBeanMapper(Order.class)
    List<Order> listOrders();
    
    @SqlQuery("SELECT * FROM ordertb WHERE orderid = ?")
    @RegisterBeanMapper(Order.class)
    List<Order> listOrdersByOrderId(Integer orderid);
    
    @SqlUpdate("DELETE FROM ordertb WHERE orderid = ?")
    void removeOrder(Integer orderid);

    
}