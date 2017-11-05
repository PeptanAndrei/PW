package com.videoteca.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iduser")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	/*
	@OneToMany(mappedBy="user")
    private List<Order> orders = new ArrayList<Order>();
	*/
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	/*
	public List<Order> getOrders(){
		return orders;
	}
	
	public void setOrders(List<Order> orders){
		this.orders = orders;
	}
	*/
}
	