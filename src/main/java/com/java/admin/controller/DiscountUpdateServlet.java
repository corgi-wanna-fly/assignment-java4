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
 * Servlet implementation class DiscountUpdateServlet
 */
@WebServlet("/DiscountUpdateServlet")
public class DiscountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id_discount = Integer.parseInt(request.getParameter("id"));
			
			DiscountDAO discountDAO = new DiscountDAO();
			
			Discount discount = discountDAO.findById(id_discount);
			
			request.setAttribute("discount", discount);
			
			PageInfo.routeAdmin(request, response, PageType.ADMIN_DISCOUNT_UPDATE_PAGE);
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
			int id_discount = Integer.parseInt(request.getParameter("id"));
			
			FormUtils formUtils = new FormUtils();
			
			DiscountDAO discountDAO = new DiscountDAO();
			
			Discount discount = formUtils.getBean(request, Discount.class);
			
			discount.setIdDiscounts(id_discount);
			
			discountDAO.update(discount);
			
			response.sendRedirect("AdminDiscountServlet");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
