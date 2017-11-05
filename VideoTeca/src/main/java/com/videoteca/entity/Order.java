package com.videoteca.entity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idorder")
	private int id;
	
	@Column(name = "totalprice")
	private int totalPrice;
	/*
	@ManyToOne
    @JoinColumn(name="iduser")
    private User user;
	
	@OneToMany(mappedBy="order")
    private List<Movie> movies = new ArrayList<Movie>();
	*/
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	/*
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public List<Movie> getMovies(){
		return movies;
	}
	
	public void setMovies(List<Movie> movies){
		this.movies = movies;
	}
	*/
}