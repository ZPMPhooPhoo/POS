package com.lumina.pos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lumina.pos.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>{

//    @Query("{ 'email': ?0, 'delFlag': ?1 }")
    Boolean existsByEmailAndDelFlag(String email, boolean delFlag);

    // @Query("{ 'email': ?0,'password' : ?0, 'delFlag': ?1 }")
    Boolean existsByEmailAndPasswordAndDelFlag(String email, String password, boolean delFlag);

}
