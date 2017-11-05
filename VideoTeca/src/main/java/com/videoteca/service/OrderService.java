package com.videoteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoteca.controller.MovieController;
import com.videoteca.entity.Movie;
import com.videoteca.entity.Order;
import com.videoteca.entity.User;
import com.videoteca.repository.MovieRepository;
import com.videoteca.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	public OrderRepository orderRepository;
	@Autowired
	public MovieRepository movieRepository;
	
	public Order saveOrder(User user) {
		Order newOrder = new Order();
		newOrder.setTotalPrice(getTotalPrice());
		newOrder.setUser(user);
		orderRepository.save(newOrder);
		return newOrder;
	}
	
	public int getTotalPrice()
	{
		int total=0;
		for(int i : MovieController.cartMovies)
		{
			Movie m = movieRepository.findOne(i);
			total+=m.getPrice();
		}
		return total;
	}
	
	public void addMovies(Order order)
	{
		for(int idMovie : MovieController.cartMovies)
		{
			Movie m = movieRepository.findOne(idMovie);
			order.addMovies(m);
		}
		orderRepository.save(order);
	}
	
	public Iterable<Order> showAllOrders() {
		return orderRepository.findAll();
	}
	
}