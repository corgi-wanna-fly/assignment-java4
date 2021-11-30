package com.java.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cart_item database table.
 * 
 */
@Entity
@Table(name="cart_item")
@NamedQuery(name="CartItem.findAll", query="SELECT c FROM CartItem c")
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cart_item")
	private int idCartItem;

	private int quantity;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="id_customers")
	private Customer customer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_products")
	private Product product;

	public CartItem() {
	}
	
	

	public CartItem(int idCartItem, int quantity, Customer customer, Product product) {
		super();
		this.idCartItem = idCartItem;
		this.quantity = quantity;
		this.customer = customer;
		this.product = product;
	}



	public int getIdCartItem() {
		return this.idCartItem;
	}

	public void setIdCartItem(int idCartItem) {
		this.idCartItem = idCartItem;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return "CartItem [idCartItem=" + idCartItem + ", quantity=" + quantity + ", customer=" + customer + ", product="
				+ product + "]";
	}

	
}