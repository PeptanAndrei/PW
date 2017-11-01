package com.videoteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoteca.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}