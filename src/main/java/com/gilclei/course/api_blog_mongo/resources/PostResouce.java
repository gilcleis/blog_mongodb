package com.gilclei.course.api_blog_mongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilclei.course.api_blog_mongo.domain.Post;
import com.gilclei.course.api_blog_mongo.domain.User;
import com.gilclei.course.api_blog_mongo.dto.UserDTO;
import com.gilclei.course.api_blog_mongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResouce {

	@Autowired
	private PostService service;

	@GetMapping(value="/{id}")
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	private ResponseEntity<List<Post>> findAll(){
		List<Post> list = service.findAll();		
		return ResponseEntity.ok().body(list);		
	}
	
}
