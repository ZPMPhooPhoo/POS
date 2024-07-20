package com.lumina.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home() {
        return "home/index";
    }
    
    @RequestMapping(value = "/reg", method=RequestMethod.GET)
    public String register() {
        return "login/register";
    }
    
}
