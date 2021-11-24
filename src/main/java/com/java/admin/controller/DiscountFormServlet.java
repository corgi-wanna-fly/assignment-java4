package com.java.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.DiscountDAO;
import com.java.model.Discount;
import com.java.utils.FormUtils;

/**
 * Servlet implementation class DiscountFormServlet
 */
@WebServlet("/DiscountFormServlet")
public class DiscountFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.routeAdmin(request, response, PageType.ADMIN_DISCOUNT_FORM_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String uri = request.getRequestURI();
			
			DiscountDAO discountDAO = new DiscountDAO();
			
			FormUtils formUtils = new FormUtils();			
			
			Discount discount = formUtils.getBean(request, Discount.class);
			
			discountDAO.insert(discount);
			
			response.sendRedirect("AdminDiscountServlet");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
