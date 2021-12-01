package com.java.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.java.common.PageInfo;
import com.java.common.PageType;
import com.java.dao.BrandDAO;
import com.java.dao.CategoryDAO;
import com.java.dao.DiscountDAO;
import com.java.dao.ProductDAO;
import com.java.model.Product;

/**
 * Servlet implementation class ProductUploadServlet
 */
@MultipartConfig
@WebServlet("/ProductUploadServlet")
public class ProductUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Part part = request.getPart("excelFile");

			String str_submit = part.getSubmittedFileName();

			if (str_submit.isEmpty()) {
				request.setAttribute("message", "Choose an excel file first!");

				request.getRequestDispatcher("AdminProductServlet").forward(request, response);
			} else {

				BrandDAO brandDAO = new BrandDAO();
				CategoryDAO categoryDAO = new CategoryDAO();
				DiscountDAO discountDAO = new DiscountDAO();
				ProductDAO productDAO = new ProductDAO();

				File file = new File(request.getServletContext().getRealPath("/documents"));

				if (!file.exists()) {
					file.mkdir();
				}

				File excel_file = new File(file, str_submit);

				part.write(excel_file.getAbsolutePath());

				// tiến hành đọc file excel

				FileInputStream fis = new FileInputStream(excel_file);

				Workbook workbook = new XSSFWorkbook(fis);

				Sheet sheet = workbook.getSheetAt(0);

				DataFormatter df = new DataFormatter();

				Iterator<Row> itr = sheet.iterator();

				List<Product> listProducts = new ArrayList<Product>();

				while (itr.hasNext()) {
					Row current = itr.next();

					Product product = new Product();

					product.setName(current.getCell(0).getStringCellValue());
					product.setDescription(current.getCell(1).getStringCellValue());
					product.setPrice(Float.parseFloat(df.formatCellValue(current.getCell(2))));
					product.setImage(current.getCell(3).getStringCellValue());
					product.setBrand(brandDAO.findById(Integer.parseInt(df.formatCellValue(current.getCell(4)))));
					product.setCategory(categoryDAO.findById(Integer.parseInt(df.formatCellValue(current.getCell(5)))));
					product.setDiscount(discountDAO.findById(Integer.parseInt(df.formatCellValue(current.getCell(6)))));

					listProducts.add(product);
				}

				for (Product item : listProducts) {
					productDAO.insert(item);
				}

				request.setAttribute("message", "Import successfully!");

				request.getRequestDispatcher("AdminProductServlet").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
