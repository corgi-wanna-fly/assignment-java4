package com.java.auth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.java.dao.AccountDAO;
import com.java.dao.CustomerDAO;
import com.java.model.Account;
import com.java.model.Customer;
import com.java.utils.CookieUtils;
import com.java.utils.SessionUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AccountDAO accountDAO = new AccountDAO();
			
			CustomerDAO customerDAO = new CustomerDAO();

			Account account = new Account();

			BeanUtils.populate(account, request.getParameterMap());

			Customer customer = customerDAO.getCustomer(account.getEmail(), account.getPassword());
			
			boolean b_isValid = customer != null;
			
			if (b_isValid) {
				if(!customer.isActive()) {
					request.setAttribute("message", "Locked account. Contact to admin for more information!");

					request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
				}else {
					// kiểm tra ghi nhớ tài khoản
					boolean b_isRemember = account.isRemember();

					if (b_isRemember) {
						// thêm cookie
						CookieUtils cookieUtils = new CookieUtils();

						cookieUtils.addCookie(response, "email", account.getEmail(), 1);
						

					}
					
					// thêm session
					SessionUtils sessionUtils = new SessionUtils();

					sessionUtils.setSession(request, "customer", customer);

					response.sendRedirect("HomeServlet");
				}
				

			} else {
				request.setAttribute("message", "Wrong account. Try again!");

				request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
