package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.java.model.OrderItem;
import com.java.utils.JpaUtils;

public class OrderItemDAO extends EntityDAO<OrderItem> {

	public OrderItemDAO() {
		super(OrderItem.class);
		// TODO Auto-generated constructor stub
	}

	public List<OrderItem> getByOrder(int id_order){
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			String jpql = "SELECT o FROM OrderItem o WHERE o.order.idOrders = :id";
			
			TypedQuery<OrderItem> query = em.createQuery(jpql, OrderItem.class);
			
			query.setParameter("id", id_order);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteByOrder(int id_order) {
		try {
			EntityManager em = JpaUtils.getEntityManager();
			
			String jpql = "SELECT o FROM OrderItem o WHERE o.order.idOrders = :id";
			
			TypedQuery<OrderItem> query = em.createQuery(jpql, OrderItem.class);
			
			query.setParameter("id", id_order);
			
			List<OrderItem> listOrderItems = query.getResultList();
			
			OrderItemDAO orderItemDAO = new OrderItemDAO();
			
			for(OrderItem orderItem : listOrderItems) {
				orderItemDAO.delete(orderItem.getIdOrderItem());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		List<OrderItem> listOrderItems = new OrderItemDAO().getByOrder(2);
		
		for(OrderItem orderItem : listOrderItems) {
			System.out.println(orderItem.toString());
		}
	}
}
