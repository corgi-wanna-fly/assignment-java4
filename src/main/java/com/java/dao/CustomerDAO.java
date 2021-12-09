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
	
	public List<Customer> getActive(boolean key){
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			TypedQuery<Customer> query = em.createNamedQuery("Customer.findActive", Customer.class);
			
			query.setParameter("key", key);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
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
	
	public static boolean isUniqueEmail(String email) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			String jpql = "SELECT c FROM Customer c WHERE c.email = :email";
			
			TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
			
			query.setParameter("email", email);
			
			Customer customer = query.getSingleResult();
			
			return customer != null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public String getMessage(Customer customer) {
		if(customer.getFullname().isEmpty()) {
			return "Hãy nhập fullname!";
		}else if(customer.getEmail().isEmpty()) {
			return "Hãy nhập emal!";
		}else if(customer.getPassword().isEmpty()) {
			return "Hãy nhập password!";
		}else if(customer.getGender() == null) {
			return "Hãy chọn giới tính!";
		}else if(isUniqueEmail(customer.getEmail())) {
			return "Email đã được đăng ký";
		}
		return null;
	}

	public static void main(String[] args) {
		
		System.out.println(new CustomerDAO().isUniqueEmail("tanvxph13005@fpt.edu.vn"));
	}
}
