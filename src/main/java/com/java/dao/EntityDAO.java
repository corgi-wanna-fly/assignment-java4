package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.java.utils.JpaUtils;

public abstract class EntityDAO<T> {
	private Class<T> entity;
	
	public EntityDAO(Class<T> cls) {
		this.entity = cls;
	}
	
	EntityManager em;
	
	EntityTransaction trans;
	
	public void open() {
		em = JpaUtils.getEntityManager();
		
		trans = em.getTransaction();
	}
	
	public void close() {
		em.close();
	}
	
	//hàm thêm đối tượng
	public void insert(T t) {
		open();
		
		try {
			trans.begin();
			
			em.persist(t);
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			trans.rollback();
			
			throw e;
		}finally {
			close();
		}
	}
	
	//hàm cập nhật đối tượng
	public void update(T t) {
		open();
		
		try {
			trans.begin();
			
			em.merge(t);
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			trans.rollback();
			
			throw e;
		}finally {
			close();
		}
	}
	
	// hàm xoá đối tượng
	public void delete(Object id) {
		open();
		
		try {
			trans.begin();
			
			T t = em.find(entity, id);
			
			em.remove(t);
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			trans.rollback();
			
			throw e;
		}finally {
			close();
		}
	}
	
	//hàm lấy danh sách bản ghi
	public List<T> getAll(){
		open();
		
		try {
			CriteriaQuery query = em.getCriteriaBuilder().createQuery();
			
			query.select(query.from(entity));
			
			return em.createQuery(query).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	//hàm tìm bản ghi theo id
	public T findById(Object id) {
		open();
		
		try {
			T t = em.find(entity, id);
			
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	//hàm tìm danh sách bản ghi giới hạn
	public List<T> getAll(boolean flag, int offset, int fetch){
		open();
		
		try {
			CriteriaQuery query = em.getCriteriaBuilder().createQuery();
			
			query.select(query.from(entity));
			
			Query q = em.createQuery(query);
			
			if(flag) {
				q.setFirstResult(offset);
				q.setMaxResults(fetch);
			}
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	
	//hàm đếm số lượng bản ghi
	public Long getCount() {
		open();
		
		try {
			CriteriaQuery query = em.getCriteriaBuilder().createQuery();
			
			Root<T> root = query.from(entity);
			
			query.select(em.getCriteriaBuilder().count(root));
			
			Query q = em.createQuery(query);
			
			return (Long) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		
		return -1L;
	}
}
