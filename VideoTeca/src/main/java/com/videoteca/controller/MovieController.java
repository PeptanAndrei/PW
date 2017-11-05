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
	
	public static ArrayList<Integer> cartMovies = new ArrayList<Integer>();
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value= "/Index", method = RequestMethod.GET)
	public String getIndex(){
		return "index.html";
	}
	
	@RequestMapping(value= "/Movie", method = RequestMethod.GET)
	public String getMovie(){
		return "movie.html";
	}
	
	@RequestMapping(value= "/Sales", method = RequestMethod.GET)
	public String getSales(){
		return "sales.html";
	}
	
	@RequestMapping(value="/addCart/{id}", method = RequestMethod.GET)
	public void addToCart(@PathVariable("id") Integer id){
		if(!cartMovies.contains(id))
			cartMovies.add(id);
	}
	
	@RequestMapping(value="/deleteCart/{id}", method = RequestMethod.GET)
	public void delFromCart(@PathVariable("id") Integer id){
		Integer i = new Integer(id);
		cartMovies.remove(i);
	}
	
	@ResponseBody
	@RequestMapping(value = "/cartMovies", method = RequestMethod.GET)
	public ArrayList<Movie> getCartMovies() {
		return movieService.showCart(cartMovies);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getWeekMovie", method = RequestMethod.GET)
	public String getMovieofTheWeek() {
		Iterable<Movie> movies = getAllMovies();
		Iterator<Movie> i = movies.iterator();
		Movie m = new Movie();
		while(i.hasNext())
			m = i.next();
		int id = m.getId();
		return "/singleMovie?id="+id;
	}
	
	@RequestMapping(value= "/Cart", method = RequestMethod.GET)
	public String getCart(){
		return "cart.html";
	}
	
	@RequestMapping(value= "/singleMovie", method = RequestMethod.GET)
	public String getSingleMovie(@QueryParam("id") int id){
		return "single.html";
	}
	
	@RequestMapping(value= "/addMovie", method = RequestMethod.GET)
	public String getAddMovieForm(){
		return "addMovieForm.html";
	}
	
	@RequestMapping(value= "/editMovie", method = RequestMethod.GET)
	public String getEditMovieForm(@QueryParam("id") int id,  Model model) {
		Movie movie = movieService.findOne(id);
		model.addAttribute("movie", movie);
		return "editMovieForm.html";
	}
	
	@ResponseBody
	@RequestMapping(value="/movies/{id}", method = RequestMethod.POST)
	public String editMovie(@PathVariable("id") Integer id, final @RequestParam("name") String name, final @RequestParam("year") int year,
			final @RequestParam("director") String director, final @RequestParam("genre") String genre,
			final @RequestParam("price") int price, @RequestParam(required=false,value="image") String image,
			final @RequestParam("video") String video) {
		movieService.editMovie(id, name, year, director, genre, price, image, video);
		String rep = "/singleMovie?id="+id;
		return "Edited <script>location.replace('"+rep+"');</script>";
	}
	
	@ResponseBody
	@RequestMapping(value="/movies", method = RequestMethod.POST)
	public String addMOVIE(final @RequestParam("name") String name, final @RequestParam("year") int year,
			final @RequestParam("director") String director, final @RequestParam("genre") String genre,
			final @RequestParam("price") int price, @RequestParam(required=false,value="image") String image, 
			final @RequestParam("video") String video) {
		Integer id = movieService.saveMovie(name, year, director, genre, price, image, video);
		String rep = "/singleMovie?id="+id;
		return "Created <script>location.replace('"+rep+"');</script>";
	}
	
	@ResponseBody
	@RequestMapping(value = "/allMovies", method = RequestMethod.GET)
	public Iterable<Movie> getAllMovies() {
		return movieService.showAllMovies();
	}
	
	@ResponseBody
	@RequestMapping(value="/getMovie/{id}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable("id") Integer id){
		return movieService.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMovie/{id}", method = RequestMethod.GET)
	public String delMovie(@PathVariable("id") Integer id){
		movieService.deleteOne(id);
		return "Deleted <script>location.replace('/Movie');</script>";
	}
	
}