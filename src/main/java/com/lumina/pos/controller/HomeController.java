package com.lumina.pos.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method=RequestMethod.GET)
    public String home(HttpSession session) {
        try {
            logger.info("Access Login Screen!");
            if(session.getAttribute("loginInfo")!=null){
                return "home/index";
            }else{
                return "redirect:/logout";
            }
        } catch (Exception e) {
            logger.warn("home page : " +e.getMessage());
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/payment", method=RequestMethod.GET)
    public String payment(HttpSession session) {
        try {
            logger.info("Access Login Screen!");
            if(session.getAttribute("loginInfo")!=null){
                return "home/payment";
            }else{
                return "redirect:/logout";
            }
        } catch (Exception e) {
            logger.warn("home page : " +e.getMessage());
            return "redirect:/error";
        }
    }
}
