package com.java.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.CartItemDAO;
import com.java.dao.ProductDAO;
import com.java.model.CartItem;
import com.java.model.Customer;
import com.java.model.Product;
import com.java.utils.CookieUtils;
import com.java.utils.FormUtils;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionUtils sessionUtils = new SessionUtils();
		
		CookieUtils cookieUtils = new CookieUtils();
		
		String id = request.getParameter("id");
		
		
		
		Customer customer = (Customer)sessionUtils.getSession(request, "customer");
		
		if(customer == null) {
			
			cookieUtils.addCookie(response, "cart", id, 24);
			
			response.sendRedirect("LoginServlet");
		}else {
			FormUtils formUtils = new FormUtils();
			
			ProductDAO productDAO = new ProductDAO();
			
			CartItemDAO cartItemDAO = new CartItemDAO();
			
			try {
				//lấy mã sản phẩm thêm
				int num_idProduct = formUtils.getInt(request, "id", -1);
				
				Product product = productDAO.findById(num_idProduct);
				
				CartItem cartItem = new CartItem();
				
				cartItem.setCustomer(customer);
				
				cartItem.setProduct(product);
				
				cartItem.setQuantity(1);
				
				cartItemDAO.insert(cartItem);
				
				response.sendRedirect("CartServlet");
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
