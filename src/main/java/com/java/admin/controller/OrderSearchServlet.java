package com.java.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.OrderDAO;
import com.java.model.Order;

/**
 * Servlet implementation class OrderSearchServlet
 */
@WebServlet("/OrderSearchServlet")
public class OrderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSearchServlet() {
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
			List<Order> listOrders;
			
			OrderDAO orderDAO = new OrderDAO();
			
			String statuses[] = request.getParameterValues("statuses");
			
			if(statuses == null) {
				listOrders = orderDAO.getAll();
			}else {
				List<String> list = Arrays.asList(statuses);
				
				listOrders = orderDAO.getByStatus(list);
			}
			

			List<String> listStatus = new ArrayList<String>();

			listStatus.add("Cho duyet");
			listStatus.add("Da duyet");
			listStatus.add("Dang van chuyen");
			listStatus.add("Giao thanh cong");

			request.setAttribute("listStatus", listStatus);

			request.setAttribute("listOrders", listOrders);

			PageInfo.routeAdmin(request, response, PageType.ADMIN_ORDER_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
