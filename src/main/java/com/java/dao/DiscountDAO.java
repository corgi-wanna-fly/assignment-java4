package com.java.dao;

import java.util.List;

import com.java.model.Discount;

public class DiscountDAO extends EntityDAO<Discount> {

	public DiscountDAO() {
		super(Discount.class);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		List<Discount> list = new DiscountDAO().getAll();
		
		for(Discount discount: list) {
			System.out.println(discount.toString());
		}
	}

}
