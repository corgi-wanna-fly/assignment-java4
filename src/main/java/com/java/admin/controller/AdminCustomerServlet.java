package com.java.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.CustomerDAO;
import com.java.dao.ManagerDAO;
import com.java.model.Customer;
import com.java.model.Manager;

/**
 * Servlet implementation class AdminCustomerServlet
 */
@WebServlet("/AdminCustomerServlet")
public class AdminCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CustomerDAO customerDAO = new CustomerDAO();

			List<Customer> listCustomers = customerDAO.getActive(true);

			request.setAttribute("listCustomers", listCustomers);

			PageInfo.routeAdmin(request, response, PageType.ADMIN_CUSTOMER_PAGE);
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
		String reload = request.getParameter("reload");

		boolean flag = true;
		if (reload == null) {
			flag = false;
		} else {
			flag = true;
		}

		try {
			CustomerDAO customerDAO = new CustomerDAO();

			List<Customer> listCustomers;
			if(flag) {
				listCustomers = customerDAO.getAll();
			}else {
				listCustomers = customerDAO.getActive(true);
			}

			request.setAttribute("listCustomers", listCustomers);

			PageInfo.routeAdmin(request, response, PageType.ADMIN_CUSTOMER_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
