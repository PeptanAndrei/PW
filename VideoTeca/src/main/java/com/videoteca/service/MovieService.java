package com.videoteca.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoteca.entity.Movie;
import com.videoteca.entity.Order;
import com.videoteca.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	public MovieRepository movieRepository;
	
	public int saveMovie(String name, int year, String director, String genre, int price, String image, String video) {
		Movie newMovie = new Movie();
		newMovie.setName(name);
		newMovie.setYear(year);
		newMovie.setDirector(director);
		newMovie.setGenre(genre);
		newMovie.setPrice(price);
		newMovie.setImage(image);
		newMovie.setVideo(video);
		movieRepository.save(newMovie);
		return newMovie.getId();
	}
	
	public void editMovie(int id, String name, int year, String director, String genre, int price, String image, String video) {
		Movie newMovie = movieRepository.findOne(id);
		newMovie.setName(name);
		newMovie.setYear(year);
		newMovie.setDirector(director);
		newMovie.setGenre(genre);
		newMovie.setPrice(price);
		newMovie.setImage(image);
		newMovie.setVideo(video);
		movieRepository.save(newMovie);
	}
	
	public Movie findOne(int id) {
		return movieRepository.findOne(id);
	}
	
	public void deleteOne(int id) {
		
		movieRepository.delete(id);
	}
	
	public Iterable<Movie> showAllMovies() {
		return movieRepository.findAll();
	}
	

	public ArrayList<Movie> showCart(ArrayList<Integer> moviesId) {
		ArrayList<Movie> cartMovies = new ArrayList<Movie>();
		for(int i : moviesId)
		{
			cartMovies.add(findOne(i));
		}
		
		return cartMovies;
	}
	
	public void addOrder(Order order, int idMovie)
	{
		Movie m = findOne(idMovie);
		m.addOrders(order);
		movieRepository.save(m);
	}
	
}