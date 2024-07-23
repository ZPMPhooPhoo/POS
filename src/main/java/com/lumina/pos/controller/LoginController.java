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
import jakarta.servlet.http.HttpSession;

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
            return "redirect:/error";
        }
        return "login/register";
    }
    @RequestMapping(value = "/register", method=RequestMethod.POST)
    public String register(User user,Model model) {
        try {
            logger.info("Create Successfully!"+user);
            userService.CreateUser(user);
        } catch (Exception e) {
            logger.warn(e.getLocalizedMessage());
            return "redirect:/error";
        }
        return "redirect:/register";
    }

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String login(Model model,HttpSession session) {
        if(session.getAttribute("loginInfo")!=null){
            return "redirect:/home";
        }
        try {
            logger.info("Access Login Screen!");
            if(session.getAttribute("invalidPass")!=null){
                model.addAttribute("invalidPass", true);
            }

            return "login/login";
        } catch (Exception e) {
            logger.warn(e.getLocalizedMessage());
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String Login(Model model,User user,HttpSession session) {
        try {
            logger.info("Access Login Screen!");
            boolean delFlag=false;
            boolean result=userService.lofinAuth(user.getEmail(),user.getPassword(),delFlag);
            if(result){
                logger.info("Login Successful!");
                session.setAttribute("loginInfo", "loginOk");
                return "redirect:/home";
            }else{
                logger.info("Login Fail!");
                session.setAttribute("invalidPass", "true");
                return "redirect:/logout";
            }
        } catch (Exception e) {
            logger.warn(e.getLocalizedMessage());
            return "redirect:/error";
        }
    }
    @RequestMapping(value = "/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        logger.info("LogOut!");
        session.removeAttribute("loginInfo");
        return "redirect:/";
    }
    
}
