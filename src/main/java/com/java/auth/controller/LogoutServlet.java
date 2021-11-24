package com.java.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.java.utils.CookieUtils;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtils cookieUtils = new CookieUtils();
		
		SessionUtils sessionUtils = new SessionUtils();
				
		cookieUtils.addCookie(response, "cart", null, 0);
		
		cookieUtils.addCookie(response, "email", null, 0);
		
		sessionUtils.removeSession(request, "customer");
		
		response.sendRedirect("HomeServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
