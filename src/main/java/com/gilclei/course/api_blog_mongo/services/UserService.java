package com.gilclei.course.api_blog_mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilclei.course.api_blog_mongo.domain.User;
import com.gilclei.course.api_blog_mongo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}

}
