package com.videoteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoteca.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
}