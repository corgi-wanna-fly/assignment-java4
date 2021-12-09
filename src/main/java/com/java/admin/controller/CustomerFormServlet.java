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
 * Servlet implementation class CustomerFormServlet
 */
@WebServlet("/CustomerFormServlet")
public class CustomerFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PageInfo.routeAdmin(request, response, PageType.ADMIN_CUSTOMER_FORM_PAGE);
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
			FormUtils formUtils = new FormUtils();
			
			CustomerDAO customerDAO = new CustomerDAO();
			
			Customer customer = formUtils.getBean(request, Customer.class);
			
			String message = customerDAO.getMessage(customer);
			
			if(message == null) {
				customerDAO.insert(customer);
				
				response.sendRedirect("AdminCustomerServlet");
			}else {
				request.setAttribute("message", message);
				
				doGet(request, response);
			}
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
