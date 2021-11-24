package com.java.cart.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.CartItemDAO;
import com.java.dao.OrderDAO;
import com.java.dao.OrderItemDAO;
import com.java.dao.ProductDAO;
import com.java.model.CartItem;
import com.java.model.Customer;
import com.java.model.Order;
import com.java.model.OrderItem;
import com.java.model.Product;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class CheckoutServlet
 */

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			SessionUtils sessionUtils = new SessionUtils();
			
			Customer customer = (Customer)sessionUtils.getSession(request, "customer");
			
			OrderDAO orderDAO = new OrderDAO();
			
			OrderItemDAO orderItemDAO = new OrderItemDAO();
			
			ProductDAO productDAO = new ProductDAO();
			
			CartItemDAO cartItemDAO = new CartItemDAO();
			
			List<CartItem> listCartItems = cartItemDAO.getByCustomer(customer.getIdCustomers());
			
			if(listCartItems.size() == 0 ) {
				
				response.sendRedirect("CartServlet");
				
			}else {
				
				//lấy dữ liệu
				int id_order = orderDAO.getLastId() + 1;
				
				double num_amount = 0;
				for(CartItem cartItem: listCartItems) {
					Product product = cartItem.getProduct();
					
					double price = (100 - product.getDiscount().getPercent()) * product.getPrice() / 100;
					
					num_amount += (price * cartItem.getQuantity());
				}
				
				Date date_current = new Date(System.currentTimeMillis());
				
				String str_address = request.getParameter("address");
				
				String str_phone = request.getParameter("phone");
				
				Order order = new Order();
				
				order.setIdOrders(id_order);
				
				order.setAmount(num_amount);
				
				order.setCreated(date_current);
				
				order.setAddress(str_address);
				
				order.setPhone(str_phone);
				
				order.setStatus("Chờ duyệt");
				
				order.setCustomer(customer);
				
				//thao tác với csdl
				orderDAO.insert(order);
				
				for(CartItem cartItem : listCartItems) {
					OrderItem orderItem = new OrderItem();
					
					Product current_Product = productDAO.findById(cartItem.getProduct().getIdProducts());
					
					orderItem.setProduct(current_Product);
					
					orderItem.setOrder(order);	
					
					orderItem.setQuantity(cartItem.getQuantity());
					
					double currrent_Price = (100 - current_Product.getDiscount().getPercent()) * current_Product.getPrice() / 100;
					
					orderItem.setPrice(currrent_Price);
					
					orderItemDAO.insert(orderItem);
									
					
				}
				
				for(CartItem cartItem : listCartItems) {
					cartItemDAO.delete(cartItem.getIdCartItem());
				}
				
				response.sendRedirect("OrderServlet");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
