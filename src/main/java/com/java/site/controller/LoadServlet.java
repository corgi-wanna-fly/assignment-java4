package com.java.site.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.ProductDAO;
import com.java.model.Product;

/**
 * Servlet implementation class LoadServlet
 */
@WebServlet("/LoadServlet")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
 
		try {
			int exist = Integer.parseInt(request.getParameter("amount"));

			ProductDAO productDAO = new ProductDAO();

			List<Product> listProducts = productDAO.getAll(true, exist, 6);

			PrintWriter pw = response.getWriter();

			for (Product product : listProducts) {
				String active = product.isActive() ? "" : "disabled";
				pw.print("<div class=\"product col-md-4\">\r\n"
						+ "					<div class=\"product-item\">	\r\n"
						+ "						<div class=\"col-2 mt-2\" style=\"background-color: red; color: white;\">-" + product.getDiscount().getPercent()  + "%</div>	\r\n"
						+ "						<a href=\"DetailServlet?id=" + product.getIdProducts() + "\"><img src=\"" + product.getImage() + "\" alt=\"\"></a>\r\n"
						+ "						<div class=\"down-content\">\r\n"
						+ "							<a href=\"DetailServlet?id=" + product.getIdProducts() +"\"><h4>" + product.getName() + "</h4></a>\r\n"
						+ "							<h6><strike>" + product.getPrice() + "</strike></h6>	\r\n"
						+ "							<h5 style=\"margin-left: 220px; color: red\">" + product.getPrice() * (100 - product.getDiscount().getPercent())/100  + "</h5>\r\n"
						+ "							<p>" + product.getDescription() + "</p>\r\n"
						+ "							<a href=\"AddCartServlet?id=" + product.getIdProducts() +"\"\r\n"
						+ "								class=\"btn btn-primary "+ active + "\">Add to Cart</a> <span>Views\r\n"
						+ "								(" + product.getView() +")</span>\r\n"
						+ "						</div>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
