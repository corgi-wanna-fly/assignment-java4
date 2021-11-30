package com.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.java.model.Order;
import com.java.utils.JpaUtils;

public class OrderDAO extends EntityDAO<Order> {

	public OrderDAO() {
		super(Order.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Order> getByCustomer(int id_customer){
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			String jpql = "SELECT o FROM Order o WHERE o.customer.idCustomers = :id";
			
			TypedQuery<Order> query = em.createQuery(jpql, Order.class);
			
			query.setParameter("id", id_customer);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int getLastId() {
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			String sql = "SELECT * FROM shopping.orders order by id_orders desc limit 1";
			
			Query query = em.createNativeQuery(sql, Order.class);
			
			List<Order> listOrders = query.getResultList();
			
			if(listOrders.size() == 0) {
				return 1;
			}else {
				return listOrders.get(0).getIdOrders();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public List<Order> getByStatus(List<String> statuses){
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			TypedQuery<Order> query = em.createNamedQuery("Order.findByStatus", Order.class);
			
			query.setParameter("statuses", statuses);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Cho duyet");
		list.add("Da duyet");
		
		List<Order> listOrders = new OrderDAO().getByStatus(list);
		
		for(Order order: listOrders) {
			System.out.println(order.toString());
		}
	}
}
