package com.videoteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoteca.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer>{

}