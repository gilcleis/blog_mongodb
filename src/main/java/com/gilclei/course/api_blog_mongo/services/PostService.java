package com.gilclei.course.api_blog_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilclei.course.api_blog_mongo.domain.Post;
import com.gilclei.course.api_blog_mongo.repositories.PostRepository;
import com.gilclei.course.api_blog_mongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findAll(){
		return repository.findAll();
	}

}