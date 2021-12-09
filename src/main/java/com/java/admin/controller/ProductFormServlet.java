package com.java.admin.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.BrandDAO;
import com.java.dao.CategoryDAO;
import com.java.dao.DiscountDAO;
import com.java.dao.ProductDAO;
import com.java.model.Brand;
import com.java.model.Product;
import com.java.utils.FormUtils;

/**
 * Servlet implementation class ProductFormServlet
 */
@MultipartConfig
@WebServlet("/ProductFormServlet")
public class ProductFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductFormServlet() {
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
			
			BrandDAO brandDAO = new BrandDAO();
			
			CategoryDAO categoryDAO = new CategoryDAO();
			
			DiscountDAO discountDAO = new DiscountDAO();
			
			//đổ dữ liệu
			
			request.setAttribute("listBrands", brandDAO.getAll());
			
			request.setAttribute("listCategories", categoryDAO.getAll());
			
			request.setAttribute("listDiscounts", discountDAO.getAll());
			
			PageInfo.routeAdmin(request, response, PageType.ADMIN_PRODUCT_FORM_PAGE);
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
		try {
			FormUtils formUtils = new FormUtils();
			
			ProductDAO productDAO = new ProductDAO();
			
			BrandDAO brandDAO = new BrandDAO();
			
			CategoryDAO categoryDAO = new CategoryDAO();
			
			DiscountDAO discountDAO = new DiscountDAO();
			
			Product product = new Product();
			
			product	= formUtils.getBean(request, Product.class);

			product.setBrand(brandDAO.findById(Integer.parseInt(request.getParameter("id_brand"))));
			
			product.setCategory(categoryDAO.findById(Integer.parseInt(request.getParameter("id_category"))));
			
			product.setDiscount(discountDAO.findById(Integer.parseInt(request.getParameter("id_discount"))));
			
			productDAO.insert(product);
			
			response.sendRedirect("AdminProductServlet");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "Add failed");
			doGet(request, response);
		}
	}

}
