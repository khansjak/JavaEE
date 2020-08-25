package com.jak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="email")
	private String mail;
	private String country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String mail, String country) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.country = country;
	}
	public User(String name, String mail, String country) {
		super();
		this.name = name;
		this.mail = mail;
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mail=" + mail + ", country=" + country + "]";
	}
	
	
	
	
}
