package com.gilclei.course.api_blog_mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gilclei.course.api_blog_mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
