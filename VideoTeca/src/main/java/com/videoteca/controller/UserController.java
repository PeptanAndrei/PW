package com.videoteca.controller;

import java.util.*;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videoteca.entity.Order;
import com.videoteca.entity.User;
import com.videoteca.service.MovieService;
import com.videoteca.service.OrderService;
import com.videoteca.service.UserService;

@Controller
public class UserController {
	
	private static int logged=0;
	
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value= "/loginUser", method = RequestMethod.GET)
	public String getLoginForm(){
		return "login.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getLoggedUsername", method = RequestMethod.GET)
	public String getUsername() {
		Iterator<User> i = (getAllUsers()).iterator();
		while(i.hasNext())
		{
			User u = i.next();
			if(u.getId() == logged) return u.getUsername();
		}
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getLoginStatus", method = RequestMethod.GET)
	public String getLoggedStatus() {
		if(logged == 0) return "/loginUser";
		else return "/Cart";
	}
	
	@RequestMapping(value= "/registerUser", method = RequestMethod.GET)
	public String getRegisterForm(){
		return "register.html";
	}
	
	@RequestMapping(value= "/user", method = RequestMethod.GET)
	public String getSingleMovie(@QueryParam("id") int id){
		return "singleUser.html";
	}
	
	@ResponseBody
	@RequestMapping(value="/users", method = RequestMethod.POST)
	public String addUSER(final @RequestParam("username") String username,
			final @RequestParam("password") String password) {
		userService.saveUser(username, password);
		return "<script>location.replace('/loginUser');</script>";
	}
	
	@ResponseBody
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logoutUSER() {
		MovieController.cartMovies.clear();
		logged=0;
	}
	
	@ResponseBody
	@RequestMapping(value="/log", method = RequestMethod.GET)
	public String logUSER(final @RequestParam("username") String username,
			final @RequestParam("password") String password) {
		Iterable<User> users = getAllUsers();
		for(User u : users)
		{
			if(username.equals(u.getUsername()))
			{
				if(password.equals(u.getPassword()))
				{
					logged = u.getId();
					return "<script>location.replace('/Cart');</script>";
				}
				else
				{
					return "<script>location.replace('/loginUser');</script>";
				}
			}
		}
		return "<script>location.replace('/loginUser');</script>";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public Iterable<User> getAllUsers() {
		return userService.showAllUsers();
	}
	
	@ResponseBody
	@RequestMapping(value="/getUser/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") Integer id){
		return userService.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/buy", method = RequestMethod.GET)
	public void buyOrder() {
		User u = userService.findOne(logged);
		Order order = orderService.saveOrder(u);
		
		for(int idMovie : MovieController.cartMovies)
		{
			movieService.addOrder(order, idMovie);
		}
		orderService.addMovies(order);
		userService.addOrder(u,order);
		MovieController.cartMovies.clear();
	}
	
}