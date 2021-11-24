package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.java.model.CartItem;
import com.java.model.Customer;
import com.java.model.Product;
import com.java.utils.JpaUtils;

public class CartItemDAO extends EntityDAO<CartItem> {

	public CartItemDAO() {
		super(CartItem.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<CartItem> getByCustomer(int id_customer){
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			String jpql = "SELECT c FROM CartItem c WHERE c.customer.idCustomers = :id";
			
			TypedQuery<CartItem> query =  em.createQuery(jpql, CartItem.class);
			
			query.setParameter("id", id_customer);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		
		CartItemDAO cartItemDAO = new CartItemDAO();
		
		List<CartItem> list = cartItemDAO.getByCustomer(1);
		
		for(CartItem cartItem: list) {
			System.out.println(cartItem.toString());
		}
	}
}
