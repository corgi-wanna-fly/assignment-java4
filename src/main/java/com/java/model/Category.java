package com.java.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;


/**
 * The persistent class for the categorys database table.
 * 
 */
@Entity
@Table(name="categorys")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categorys")
	private int idCategorys;

	private String description;

	private String image;

	private String name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category",  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Product> products = new LinkedHashSet<Product>();

	public Category() {
	}

	public int getIdCategorys() {
		return this.idCategorys;
	}

	public void setIdCategorys(int idCategorys) {
		this.idCategorys = idCategorys;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	@Override
	public String toString() {
		return "Category [idCategorys=" + idCategorys + ", description=" + description + ", image=" + image + ", name="
				+ name + "]";
	}
	
	

}