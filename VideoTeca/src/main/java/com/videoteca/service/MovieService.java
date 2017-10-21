package com.videoteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoteca.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	public MovieRepository movieRepository;
	
}