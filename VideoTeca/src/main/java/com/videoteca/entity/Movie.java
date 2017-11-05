package com.videoteca.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idmovie")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "video")
	private String video;
	/*
	@ManyToOne
    @JoinColumn(name="idorder")
    private Order order;
	*/
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
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getVideo() {
		return video;
	}
	
	public void setVideo(String video) {
		this.video = video;
	}
	/*
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	*/
}