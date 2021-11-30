package com.java.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.CustomerDAO;
import com.java.model.Customer;
import com.java.utils.FormUtils;

/**
 * Servlet implementation class CustomerUpdateServlet
 */
@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CustomerDAO customerDAO = new CustomerDAO();
			
			int id_customer = Integer.parseInt(request.getParameter("id"));
			
			Customer customer = customerDAO.findById(id_customer);
			
			request.setAttribute("customer", customer);
			
			PageInfo.routeAdmin(request, response, PageType.ADMIN_CUSTOMER_UPDATE_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CustomerDAO customerDAO = new CustomerDAO();
			
			FormUtils formUtils = new FormUtils();
			
			int idCustomers = Integer.parseInt(request.getParameter("id"));
			
			Customer customer = formUtils.getBean(request, Customer.class);
			
			customer.setIdCustomers(idCustomers);
			
			customerDAO.update(customer);
			
			response.sendRedirect("AdminCustomerServlet");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
