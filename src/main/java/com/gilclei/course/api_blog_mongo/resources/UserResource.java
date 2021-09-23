package com.gilclei.course.api_blog_mongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gilclei.course.api_blog_mongo.domain.Post;
import com.gilclei.course.api_blog_mongo.domain.User;
import com.gilclei.course.api_blog_mongo.dto.UserDTO;
import com.gilclei.course.api_blog_mongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	private ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));		
	}
	
	@PostMapping
	private ResponseEntity<User> insert(@RequestBody UserDTO objDTO){
		User obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();		
	}
	
	@DeleteMapping(value = "/{id}")
	private ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
	
	@PutMapping(value = "/{id}")
	private ResponseEntity<Void> Update(@RequestBody UserDTO objDTO,@PathVariable String id){
		User obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);		 
		return ResponseEntity.noContent().build();		
	}
	
	@GetMapping(value = "/{id}/posts")
	private ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());		
	}

}
