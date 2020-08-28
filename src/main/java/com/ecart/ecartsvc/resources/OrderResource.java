package com.ecart.ecartsvc.resources;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jdbi.v3.core.transaction.TransactionIsolationLevel;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import com.ecart.ecartsvc.model.Order;
import com.ecart.ecartsvc.model.Product;
import com.ecart.ecartsvc.service.OrderService;
import com.ecart.ecartsvc.service.ProductService;

@Path("/api")
public class OrderResource {
	
	@Inject
	OrderService orderservice;
	
	@Inject
	ProductService productservice;
	
	/**
	 * Retrieve orders
	 * @return
	 */
	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> retrieveOrders() {
				
		return orderservice.retrieveOrders();
	}
	
	/**
	 * Place a dummy order. Order placement should fail if the stock = number of dummy orders 
	 * @param order
	 * @param product
	 */
	@POST
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transaction(TransactionIsolationLevel.READ_COMMITTED)
	public Response placeOrders(Order order) {
		
		if(order.getQuantity() < 1 || order.getOrderid() < 1 ) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		List<Product> products =  productservice.retrieveProductByProductcode(order.getProduct());
       
		if(products.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity("Product not found").build();
		}
		
		Product product = products.get(0);
		
		if(order.getQuantity() > product.getStock()) {
			
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Item not in stock").build();
		}else {
			
			orderservice.placeOrders(order, product);
			
		}

		return Response.status(Status.CREATED).build();
	}
	
	/**
	 * Delete the dummy order(s)
	 * @param order
	 * @param product
	 */
	@DELETE
	@Path("/orders/{orderid}")
	@Transaction(TransactionIsolationLevel.READ_COMMITTED)
	public Response delete(@PathParam("orderid") Integer orderid) {
		
		List<Order> orders = orderservice.listOrdersByOrderId(orderid);
		
		if(orders.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity("Order not found").build();
		}
		
		Order order = orders.get(0);
		
		
		List<Product> products =  productservice.retrieveProductByProductcode(order.getProduct());
       
		if(products.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity("Product not found").build();
		}
		
		Product product = products.get(0);
		
		orderservice.delete(order, product);

		return Response.status(202).build();
	}
}
