package com.java.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reviews database table.
 * 
 */
@Entity
@Table(name="reviews")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reviews")
	private int idReviews;

	private String comment;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="id_customers")
	private Customer customer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_products")
	private Product product;

	public Review() {
	}

	public int getIdReviews() {
		return this.idReviews;
	}

	public void setIdReviews(int idReviews) {
		this.idReviews = idReviews;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Review [idReviews=" + idReviews + ", comment=" + comment + ", customer=" + customer + ", product="
				+ product + "]";
	}

	
}