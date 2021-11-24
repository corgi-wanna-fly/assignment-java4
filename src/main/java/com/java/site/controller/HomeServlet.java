package com.java.site.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.CustomerDAO;
import com.java.dao.ProductDAO;
import com.java.model.Customer;
import com.java.model.Product;
import com.java.utils.CookieUtils;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//kiểm tra đăng nhập
			
			CookieUtils cookieUtils = new CookieUtils();
			
			SessionUtils sessionUtils = new SessionUtils();
			
			Cookie email = cookieUtils.getCookie(request, "email");
			
			
			if(email != null) {
				Customer customer = sessionUtils.getSession(request, "customer");
			}
			
			//xử lí dữ liệu
			ProductDAO productDAO = new ProductDAO();
			
			//load dữ liệu sản phẩm
			List<Product> listProducts = productDAO.getAll(true, 0, 6);
			
			request.setAttribute("listProducts", listProducts);
			
			request.setAttribute("flag", "Home");
			
			PageInfo.routeSite(request, response, PageType.HOME_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
