package com.lumina.pos.controller;

import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lumina.pos.common.Constant;
import com.lumina.pos.model.User;
import com.lumina.pos.service.UserService;

import ch.qos.logback.classic.Logger;

@Controller
public class LoginController {
     private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);

     @Autowired
     private UserService userService;
     //create user 
      @RequestMapping(value = "/register", method=RequestMethod.GET)
    public String Register(User user,Model model) {
        try {
            logger.info("Accept Register Screen!");
            HashMap<String, String> genderList = Constant.gender();
            model.addAttribute("genderList", genderList);
            model.addAttribute("user", user);
        } catch (Exception e) {
            logger.warn(e.getLocalizedMessage());
            return "redirect:/common/error";
        }
        return "login/register";
    }
    @RequestMapping(value = "/register", method=RequestMethod.POST)
    public String register(User user,Model model) {
        try {
            logger.info("Register Screen!"+user);
            userService.CreateUser(user);
        } catch (Exception e) {
            logger.warn(e.getLocalizedMessage());
            return "redirect:/common/error";
        }
        return "redirect:/register";
    }
}
