package com.java.cart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.CartItemDAO;
import com.java.model.CartItem;
import com.java.model.Customer;
import com.java.utils.CookieUtils;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			SessionUtils sessionUtils = new SessionUtils();
			
			CartItemDAO cartItemDAO = new CartItemDAO();
			
			Customer customer = (Customer)sessionUtils.getSession(request, "customer");
			
			List<CartItem> listCartItems = cartItemDAO.getByCustomer(customer.getIdCustomers());
			
			//lấy dữ liệu để cập nhật
			String id = request.getParameter("id");
			
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			for(CartItem cartItem: listCartItems) {
				if(cartItem.getProduct().getIdProducts() == Integer.parseInt(id)) {
					cartItem.setQuantity(quantity);
					cartItemDAO.update(cartItem);
				}
			}
			response.sendRedirect("CartServlet");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
