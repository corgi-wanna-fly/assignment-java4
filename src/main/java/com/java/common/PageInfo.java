package com.java.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	
	public PageInfo() {
		super();
	}




	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}




	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContentUrl() {
		return contentUrl;
	}


	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}


	public String getScriptUrl() {
		return scriptUrl;
	}


	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	private static Map<PageType, PageInfo> map = new HashMap<PageType, PageInfo>();
	
	static {
		map.put(PageType.HOME_PAGE, new PageInfo("Home Page", "/views/sites/home.jsp", ""));
		map.put(PageType.PRODUCT_PAGE, new PageInfo("Product Page", "/views/sites/product.jsp", ""));
		map.put(PageType.CART_PAGE, new PageInfo("Cart Page", "/views/sites/cart.jsp", ""));
		map.put(PageType.ORDER_PAGE, new PageInfo("Order Page", "/views/sites/order.jsp", ""));
		map.put(PageType.DETAIL_ORDER_PAGE, new PageInfo("Detail Order Page", "/views/sites/detail-order.jsp", ""));
		map.put(PageType.DETAIL_PRODUCT_PAGE, new PageInfo("Detail Product Page", "/views/sites/detail.jsp", ""));
		map.put(PageType.ADMIN_HOME_PAGE, new PageInfo("Admin Page", "/views/admins/home.jsp", ""));
		map.put(PageType.ADMIN_ORDER_PAGE, new PageInfo("Admin Order Page", "/views/admins/order.jsp", ""));
		map.put(PageType.ADMIN_CUSTOMER_PAGE, new PageInfo("Admin Customer Page", "/views/admins/customer.jsp", ""));
		map.put(PageType.ADMIN_PRODUCT_PAGE, new PageInfo("Admin Product Page", "/views/admins/product.jsp", ""));
		map.put(PageType.ADMIN_DISCOUNT_PAGE, new PageInfo("Admin Discount Page", "/views/admins/discount.jsp", ""));
		map.put(PageType.ADMIN_DISCOUNT_FORM_PAGE, new PageInfo("Admin Discount Form Page", "/views/admins/discount-form.jsp", ""));
		map.put(PageType.ADMIN_DISCOUNT_UPDATE_PAGE, new PageInfo("Admin Discount Update Page", "/views/admins/discount-update.jsp", ""));
		map.put(PageType.ADMIN_PRODUCT_FORM_PAGE, new PageInfo("Admin Product Form Page", "/views/admins/product-form.jsp", ""));
		map.put(PageType.ADMIN_PRODUCT_UPDATE_PAGE, new PageInfo("Admin Product Update Page", "/views/admins/product-update.jsp", ""));
		map.put(PageType.SEARCH_PAGE, new PageInfo("Search Page", "/views/sites/search.jsp", ""));
	}
	
	//hàm chuyển trang thường
	public static void routeSite(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		PageInfo pageInfo = map.get(pageType);
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.getRequestDispatcher("/views/sites/index.jsp").forward(request, response);
	}
	
	//hàm chuyển trang admin
	public static void routeAdmin(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		PageInfo pageInfo = map.get(pageType);
		
		request.setAttribute("pageInfo", pageInfo);
		
		request.getRequestDispatcher("/views/admins/dashboard.jsp").forward(request, response);
	}
}
