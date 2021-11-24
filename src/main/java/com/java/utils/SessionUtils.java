package com.java.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	public void setSession(HttpServletRequest request, String name, Object value) {
		HttpSession session = request.getSession();
		
		session.setAttribute(name, value);
	}
	
	public <T> T getSession(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		
		return (T)session.getAttribute(name);
	}
	
	public void removeSession(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		
		session.removeAttribute(name);
	}
}
