package com.java.utils;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.github.cdimascio.dotenv.Dotenv;

public class JpaUtils {
	private static EntityManagerFactory factory;
	
	private static EntityManager em;
	
	public static final String FINAL_URL = "javax.persistence.jdbc.url";
	
	public static final String FINAL_USER = "javax.persistence.jdbc.user";
	
	public static final String FINAL_PASSWORD = "javax.persistence.jdbc.password";
	
	public static final String FINAL_DRIVER = "javax.persistence.jdbc.driver";
	
	public static EntityManagerFactory getFactory() {
		Map<String, String> map = new HashMap();
		
		Dotenv dotenv = Dotenv.configure()
		        .directory("E:\\eclipse-workspace\\java-assignment\\")
		        .ignoreIfMalformed()
		        .ignoreIfMissing()
		        .load();
		
		map.put(FINAL_URL, dotenv.get(FINAL_URL));
		map.put(FINAL_USER, dotenv.get(FINAL_USER));
		map.put(FINAL_PASSWORD, dotenv.get(FINAL_PASSWORD));
		map.put(FINAL_DRIVER, dotenv.get(FINAL_DRIVER));
		
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("java-assignment", map);
		}
		
		return factory;
	}
	public static EntityManager getEntityManager() {
		if(em == null || !em.isOpen()) {
			em = getFactory().createEntityManager();
		}
		
		return em;
	}
	
	public static void main(String[] args) {
		EntityManager em = JpaUtils.getEntityManager();
		if(em != null) {
			System.out.println("OK");
		}else {
			System.out.println("NOT");
		}
	}
}
