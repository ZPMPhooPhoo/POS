package com.lumina.pos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lumina.pos.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>{

    
}
