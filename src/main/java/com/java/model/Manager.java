package com.java.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the managers database table.
 * 
 */
@Entity
@Table(name="managers")
@NamedQuery(name="Manager.findAll", query="SELECT m FROM Manager m")
public class Manager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_managers")
	private int idManagers;

	private String password;

	private String username;

	public Manager() {
	}

	public int getIdManagers() {
		return this.idManagers;
	}

	public void setIdManagers(int idManagers) {
		this.idManagers = idManagers;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}