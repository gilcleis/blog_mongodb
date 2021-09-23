package com.gilclei.course.api_blog_mongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String mensage) {
		super(mensage);		
	}

}
