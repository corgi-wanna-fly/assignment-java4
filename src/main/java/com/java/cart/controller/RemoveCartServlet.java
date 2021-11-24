package com.java.cart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.CartItemDAO;
import com.java.model.CartItem;
import com.java.model.Customer;
import com.java.utils.CookieUtils;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CartItemDAO cartItemDAO = new CartItemDAO();
			
			SessionUtils sessionUtils = new SessionUtils();
			
			Customer customer = (Customer)sessionUtils.getSession(request, "customer");
			
			List<CartItem> list = cartItemDAO.getByCustomer(customer.getIdCustomers());
			
			int num_id = Integer.parseInt(request.getParameter("id"));
			
			for(CartItem cartItem: list) {
				if(cartItem.getProduct().getIdProducts() ==  num_id) {
					cartItemDAO.delete(cartItem.getIdCartItem());
				}
			}
			
			
			response.sendRedirect("CartServlet");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
