package com.ecart.ecartsvc.service;

import java.util.List;

import com.ecart.ecartsvc.config.JdbiConfig;
import com.ecart.ecartsvc.dao.OrderDao;
import com.ecart.ecartsvc.dao.ProductDao;
import com.ecart.ecartsvc.model.Order;
import com.ecart.ecartsvc.model.Product;


public class OrderService {
	

	/**
	 * Retrieve orders
	 * @return
	 */
	public List<Order> retrieveOrders() {
				
		List<Order> orders =  JdbiConfig.getJdbi1().withExtension(OrderDao.class, dao -> {
            return dao.listOrders();
			});

		return orders;
	}
	
	/**
	 * Retrieve orders by order id
	 * @return
	 */
	public List<Order> listOrdersByOrderId(Integer orderid) {
				
		List<Order> orders =  JdbiConfig.getJdbi1().withExtension(OrderDao.class, dao -> {
            return dao.listOrdersByOrderId(orderid);
			});

		return orders;
	}
	
	
	/**
	 * Place a dummy order. Order placement should fail if the stock = number of dummy orders 
	 * @param order
	 * @param product
	 */
	public void placeOrders(Order order, Product product) {
		
			JdbiConfig.getJdbi1().withExtension(ProductDao.class, dao -> {
				dao.updateProduct(product.getStock() - order.getQuantity(), order.getProduct());
	            return null;
			});
			
			JdbiConfig.getJdbi1().withExtension(OrderDao.class, dao -> {
	            dao.insertBean(order);
	            return null;
	        });
	}
	

	/**
	 * Delete the dummy order(s)
	 * @param order
	 * @param product
	 */
	public void delete(Order order, Product product) {
		
		
		JdbiConfig.getJdbi1().withExtension(OrderDao.class, dao -> {
            dao.removeOrder(order.getOrderid());
            return null;
        });
		
		
		JdbiConfig.getJdbi1().withExtension(ProductDao.class, dao -> {
			dao.updateProduct(product.getStock() + order.getQuantity(), order.getProduct());
            return null;
		});

	}
}
