package com.videoteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videoteca.entity.Order;
import com.videoteca.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping(value = "/allOrders", method = RequestMethod.GET)
	public Iterable<Order> getAllOrders() {
		return orderService.showAllOrders();
	}
	
	@RequestMapping(value= "/historyOrders", method = RequestMethod.GET)
	public String getLoginForm(){
		return "orders.html";
	}
	
}