package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.java.model.Manager;
import com.java.utils.JpaUtils;

public class ManagerDAO extends EntityDAO<Manager> {

	public ManagerDAO() {
		super(Manager.class);
		// TODO Auto-generated constructor stub
	}
	
	public Manager getManager(String username, String password) {
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			String jpql = "SELECT m FROM Manager m WHERE m.username = :username AND m.password = :password";
			
			TypedQuery<Manager> query = em.createQuery(jpql, Manager.class);
			
			query.setParameter("username", username);
			
			query.setParameter("password", password);
			
			Manager manager = query.getSingleResult();
			
			return manager;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
