package com.java.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.OrderDAO;
import com.java.model.Customer;
import com.java.model.Order;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			OrderDAO orderDAO = new OrderDAO();
			
			SessionUtils sessionUtils = new SessionUtils();
			
			Customer customer = (Customer)sessionUtils.getSession(request, "customer");
			
			List<Order> listOrders = orderDAO.getByCustomer(customer.getIdCustomers());
			
			if(listOrders.size() == 0) {
				request.setAttribute("message", "Empty List");
			}
			
			request.setAttribute("listOrders", listOrders);
			
			request.setAttribute("flag", "Orders");
			
			PageInfo.routeSite(request, response, PageType.ORDER_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
