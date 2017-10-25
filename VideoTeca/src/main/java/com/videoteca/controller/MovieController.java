package com.videoteca.controller;

import java.util.*;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videoteca.entity.Movie;
import com.videoteca.service.MovieService;

@Controller
public class MovieController {
	
	public ArrayList<Integer> cartMovies = new ArrayList<Integer>();
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/addCart/{id}", method = RequestMethod.GET)//edit method
	public void addToCart(@PathVariable("id") int id){
		if(!cartMovies.contains(id))
			cartMovies.add(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/cartMovies", method = RequestMethod.GET)
	public ArrayList<Movie> getCartMovies() {
		return movieService.showCart(cartMovies);
	}
	
	@RequestMapping(value= "/singleMovie", method = RequestMethod.GET)//return form page to create movie
	public String getSingleMovie(@QueryParam("id") int id){
		return "single.html";
	}
	
	@RequestMapping(value= "/addMovie", method = RequestMethod.GET)//return form page to create movie
	public String getAddMovieForm(){
		return "addMovieForm.html";
	}
	
	@RequestMapping(value= "/editMovie", method = RequestMethod.GET)//return a form where you can edit a movie
	public String getEditMovieForm(@QueryParam("id") int id,  Model model) {
		Movie movie = movieService.findOne(id);
		model.addAttribute("movie", movie);
		return "editMovieForm.html";
	}
	
	@ResponseBody
	@RequestMapping(value="/movies/{id}", method = RequestMethod.POST)//edit method
	public String editMovie(@PathVariable("id") Integer id, final @RequestParam("name") String name, final @RequestParam("year") int year,
			final @RequestParam("director") String director, final @RequestParam("genre") String genre,
			final @RequestParam("price") int price, @RequestParam(required=false,value="image") String image,
			final @RequestParam("video") String video) {
		movieService.editMovie(id, name, year, director, genre, price, image, video);
		String rep = "/singleMovie?id="+id;
		return "Edited <script>location.replace('"+rep+"');</script>";
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