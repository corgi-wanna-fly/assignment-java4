package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.java.model.Customer;
import com.java.utils.JpaUtils;

public class CustomerDAO extends EntityDAO<Customer> {

	public CustomerDAO() {
		super(Customer.class);
		// TODO Auto-generated constructor stub
	}
	
	public Customer getCustomer(String email, String password) {
		EntityManager em = JpaUtils.getEntityManager();
		
		try {
			String jpql = "SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password";
			
			TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
			
			query.setParameter("email", email);
			
			query.setParameter("password", password);
			
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	public static void main(String[] args) {
		Customer customer = new CustomerDAO().getCustomer("tanvx308@gmail.com", "123456");
		
		if(customer == null) {
			System.out.println("null");
		}else {
			System.out.println(customer.toString());
		}
	}
}
