package com.java.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	//hàm lấy cookie
	public Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) return null;
		for(Cookie item: cookies) {
			if(item.getName().equalsIgnoreCase(name)) {
				return item;
			}
		}
		return null;
	}
	
	//hàm tạo cookie
	public void addCookie(HttpServletResponse response, String name, String value, int hours) {
		Cookie cookie = new Cookie(name, value);
		
		cookie.setMaxAge(60 * 60 * hours);
		
		cookie.setPath("/");
		
		response.addCookie(cookie);
	}
}
