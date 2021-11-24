package com.java.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_item database table.
 * 
 */
@Entity
@Table(name="order_item")
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_order_item")
	private int idOrderItem;

	private double price;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="id_orders")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_products")
	private Product product;

	public OrderItem() {
	}

	public int getIdOrderItem() {
		return this.idOrderItem;
	}

	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [idOrderItem=" + idOrderItem + ", price=" + price + ", quantity=" + quantity + ", order="
				+ order + ", product=" + product + "]";
	}

	
}