package com.videoteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videoteca.entity.Movie;
import com.videoteca.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value= "/addMovie", method = RequestMethod.GET)//return form page to create movie
	public String getAddMovieForm(){
		return "addMovieForm.html";
	}
	
	@ResponseBody
	@RequestMapping(value="/movies", method = RequestMethod.POST)//create method
	public String addMOVIE(final @RequestParam("name") String name, final @RequestParam("year") int year,
			final @RequestParam("director") String director, final @RequestParam("genre") String genre,
			final @RequestParam("price") int price, @RequestParam(required=false,value="image") String image, 
			final @RequestParam("video") String video) {
		int id = movieService.saveMovie(name, year, director, genre, price, image, video);
		String rep = "/singleMovie?id="+id;
		return "Created <script>location.replace('"+rep+"');</script>";
	}
	
	@ResponseBody
	@RequestMapping(value = "/allMovies", method = RequestMethod.GET)
	public Iterable<Movie> getAllMovies() {
		return movieService.showAllMovies();
	}
	
	@ResponseBody
	@RequestMapping(value="/getMovie/{id}", method = RequestMethod.GET)//create method
	public Movie getMovie(@PathVariable("id") int id){
		return movieService.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMovie/{id}", method = RequestMethod.GET)//create method
	public String delMovie(@PathVariable("id") int id){
		movieService.deleteOne(id);
		return "deleted";//"Edited <script>location.replace('/singleMovie?id=1');</script>";
	}
	
}