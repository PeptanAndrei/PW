package com.videoteca.entity;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;;

//@JsonIdentityInfo(
//generator = ObjectIdGenerators.PropertyGenerator.class, 
//property = "id")
@Entity
@Table(name = "shoppingorder")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idorder")
	private int id;
	
	@Column(name = "totalprice")
	private int totalPrice;
	
	@ManyToOne
    @JoinColumn(name="iduser")
    private User user;
	
	@ManyToMany
	@JoinTable(name = "ordermovie", joinColumns = @JoinColumn(name = "idorder", referencedColumnName = "idorder"), inverseJoinColumns = @JoinColumn(name = "idmovie", referencedColumnName = "idmovie"))
    private List<Movie> movies = new ArrayList<Movie>();
	
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
	
	public void addMovies(Movie movie){
		this.movies.add(movie);
	}
	
}