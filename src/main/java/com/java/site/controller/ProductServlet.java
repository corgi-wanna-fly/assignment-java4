package com.java.site.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.CategoryDAO;
import com.java.dao.ProductDAO;
import com.java.model.Category;
import com.java.model.Product;
import com.java.utils.FormUtils;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductDAO productDAO = new ProductDAO();
			
			FormUtils formUtils = new FormUtils();
			
			CategoryDAO categoryDAO = new CategoryDAO();
			
			//đếm số trang
			Long num_productCount = productDAO.getCount();
			
			Long num_countPage = num_productCount % 6 == 0 ? num_productCount/6 : num_productCount/6 + 1;
			
			//lấy trang hiện tại
			int num_page = formUtils.getInt(request, "page", 1);
			
			//lấy danh sách product
			List<Product> listProducts = productDAO.getAll(true, (num_page - 1) * 6, 6);
			
			//lấy danh sách loại sản phẩm
			List<Category> listCategories = categoryDAO.getAll();
			
			for(Category category: listCategories) {
				category.setName(category.getName().toUpperCase());
			}
			//xử lí dữ liệu
			request.setAttribute("pageCount", num_countPage);
			
			request.setAttribute("index", num_page);
			
			request.setAttribute("listProducts", listProducts);
			
			request.setAttribute("listCategories", listCategories);
			
			request.setAttribute("flag", "Products");
			
			PageInfo.routeSite(request, response, PageType.PRODUCT_PAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
