package com.lumina.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class registrationController {
    @RequestMapping(value = "/registration", method=RequestMethod.GET)
    public String requestMethodName() {
        return "registration";
    }
    
}
