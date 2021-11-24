package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.java.model.Brand;
import com.java.utils.JpaUtils;

public class BrandDAO extends EntityDAO<Brand>{

	
	public BrandDAO() {
		super(Brand.class);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Brand> list = new BrandDAO().getAll();
		
		for(Brand item: list) {
			System.out.println(item.toString());
		}
	}
}
