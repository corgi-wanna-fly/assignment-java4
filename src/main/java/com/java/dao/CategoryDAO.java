package com.java.dao;

import java.util.List;

import com.java.model.Category;
import com.java.model.Product;

public class CategoryDAO extends EntityDAO<Category> {

	public CategoryDAO() {
		super(Category.class);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		List<Category> list = new CategoryDAO().getAll();
		
		for(Category product: list) {
			System.out.println(product.toString());
		}
//		Category category = new CategoryDAO().findById(1);
//		System.out.println(category.toString());
	}

}
