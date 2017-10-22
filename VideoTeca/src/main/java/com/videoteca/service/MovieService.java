package com.videoteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoteca.entity.Movie;
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
	
	public Movie findOne(int id) {
		return movieRepository.findOne(id);
	}
	
	public void deleteOne(int id) {
		
		movieRepository.delete(id);
		//movieRepository.save(movieRepository.findAll());
	}
	
	public Iterable<Movie> showAllMovies() {
		return movieRepository.findAll();
	}
	
}