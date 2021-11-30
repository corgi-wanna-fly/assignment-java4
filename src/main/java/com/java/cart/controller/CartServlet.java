package com.java.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.CartItemDAO;
import com.java.dao.ProductDAO;
import com.java.model.CartItem;
import com.java.model.Customer;
import com.java.model.Product;
import com.java.utils.CookieUtils;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			CookieUtils cookieUtils = new CookieUtils();
			
			CartItemDAO cartItemDAO = new CartItemDAO();
			
			Cookie c_Cart = cookieUtils.getCookie(request, "cart");

			ProductDAO productDAO = new ProductDAO();

			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			HttpSession session = request.getSession();

			Customer customer = (Customer) session.getAttribute("customer");

			List<CartItem> listCartItems = cartItemDAO.getByCustomer(customer.getIdCustomers());
			
			if(c_Cart != null) {
				int id = Integer.parseInt(c_Cart.getValue());
				CartItem cartItem = new CartItem();
				cartItem.setCustomer(customer);
				cartItem.setProduct(productDAO.findById(id));
				cartItem.setQuantity(1);
				
				cartItemDAO.insert(cartItem);
				map.put(id, 1);
				
				cookieUtils.addCookie(response, "cart", null, 0);
			}
			
			for(CartItem cartItem: listCartItems) {
				int id_item = cartItem.getProduct().getIdProducts();
				if(!map.containsKey(id_item)) {
					map.put(id_item, cartItem.getQuantity());
				}else {
					map.replace(id_item, map.get(id_item), map.get(id_item) + cartItem.getQuantity());
				}
			}
			
			Set<Integer> set = map.keySet();

			List<Product> listProducts = new ArrayList<Product>();

			List<Integer> listQuantities = new ArrayList<Integer>();

			for (Integer cartItem : set) {
				Product product = productDAO.findById(cartItem);
				listProducts.add(product);
				listQuantities.add(map.get(cartItem));
			}

			request.setAttribute("amount", productDAO.getAmount(listProducts, listQuantities));

			request.setAttribute("listProducts", listProducts);

			request.setAttribute("listQuantities", listQuantities);

			request.setAttribute("count", listProducts.size());
			
			
			if (map.size() == 0) {
				request.setAttribute("amount", 0);

				request.setAttribute("count", 0);

				request.setAttribute("message", "Empty Cart");
			}
			
			request.setAttribute("flag", "Cart");
	
		
			PageInfo.routeSite(request, response, PageType.CART_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
