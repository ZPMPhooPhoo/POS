package com.lumina.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumina.pos.model.User;
import com.lumina.pos.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void CreateUser(User user){
        userRepo.save(user);
    }

    public Boolean checkUser(String email,boolean delFlag){
        boolean res=userRepo.existsByEmailAndDelFlag(email, delFlag);
        return res;
    }

    public Boolean lofinAuth(String email,String password,boolean delFlag){
        boolean res=userRepo.existsByEmailAndPasswordAndDelFlag(email,password, delFlag);
        return res;
    }
}
