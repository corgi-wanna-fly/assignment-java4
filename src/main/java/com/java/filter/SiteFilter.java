package com.java.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.Customer;

/**
 * Servlet Filter implementation class SiteServlet
 */
@WebFilter()
public class SiteFilter implements Filter {

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		Customer customer = (Customer) session.getAttribute("customer");
		
		if(customer == null) {
			res.sendRedirect("/java-assignment/LoginServlet");
		}else {
			chain.doFilter(request, response);
		}
		
	}


}
