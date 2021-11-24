package com.java.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the discounts database table.
 * 
 */
@Entity
@Table(name="discounts")
@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d")
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_discounts")
	private int idDiscounts;

	private String description;

	private String name;

	private int percent;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="discount")
	private List<Product> products;

	public Discount() {
	}

	public int getIdDiscounts() {
		return this.idDiscounts;
	}

	public void setIdDiscounts(int idDiscounts) {
		this.idDiscounts = idDiscounts;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercent() {
		return this.percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setDiscount(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setDiscount(null);

		return product;
	}

	@Override
	public String toString() {
		return "Discount [idDiscounts=" + idDiscounts + ", description=" + description + ", name=" + name + ", percent="
				+ percent + "]";
	}
	
	

}