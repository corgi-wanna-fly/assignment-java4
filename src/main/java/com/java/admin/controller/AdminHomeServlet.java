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
import com.java.dao.OrderDAO;
import com.java.dao.ProductDAO;
import com.java.model.Product;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CustomerDAO customerDAO = new CustomerDAO();
			
			ProductDAO productDAO = new ProductDAO();
			
			OrderDAO orderDAO = new OrderDAO();
			
			SessionUtils sessionUtils = new SessionUtils();
			
			request.setAttribute("count_Customer", customerDAO.getCount());
			
			request.setAttribute("count_Product", productDAO.getCount());
			
			request.setAttribute("count_Order", orderDAO.getCount());
			
			request.setAttribute("admin", sessionUtils.getSession(request, "admin"));
			
			PageInfo.routeAdmin(request, response, PageType.ADMIN_HOME_PAGE);
			
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
