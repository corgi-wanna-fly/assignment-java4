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
import com.java.model.Category;
import com.java.model.Product;
import com.java.utils.FormUtils;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FormUtils formUtils = new FormUtils();
			
			CategoryDAO categoryDAO = new CategoryDAO();
			
			//lấy danh sách loại sản phẩm
			List<Category> listCategories = categoryDAO.getAll();
			
			for(Category category: listCategories) {
				category.setName(category.getName().toUpperCase());
			}
			
			//lấy mã loại sản phẩm
			int nums_idCategorys = formUtils.getInt(request, "id", 1);
			
			//lấy danh sách sản phẩm theo mã
			Category category = categoryDAO.findById(nums_idCategorys);
			
			List<Product> listProducts = (List<Product>) category.getProducts();
			
			//xử lí dữ liệu
			request.setAttribute("listCategories", listCategories);
			
			request.setAttribute("listProducts", listProducts);
			
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
