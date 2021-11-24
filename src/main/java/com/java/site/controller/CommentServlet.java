package com.java.site.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.ProductDAO;
import com.java.dao.ReviewDAO;
import com.java.model.Customer;
import com.java.model.Product;
import com.java.model.Review;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			SessionUtils sessionUtils = new SessionUtils();
			
			Customer customer = (Customer)sessionUtils.getSession(request, "customer");
			
			if(customer == null) {
				response.sendRedirect("LoginServlet");
			}else {
				ReviewDAO reviewDAO = new ReviewDAO();
				
				Review review = new Review();
				
				ProductDAO productDAO = new ProductDAO();
				
				int id_product = Integer.parseInt(request.getParameter("id"));
				
				Product product = productDAO.findById(id_product);
				
				String str_comment = request.getParameter("comment");
				
				review.setCustomer(customer);
				
				review.setProduct(product);
				
				review.setComment(str_comment);
				
				reviewDAO.insert(review);
				
				response.sendRedirect("DetailServlet?id=" + id_product);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
