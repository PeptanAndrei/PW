package com.videoteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.videoteca.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
}