package com.lumina.pos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class testingController {
    @RequestMapping(value = "/testing", method=RequestMethod.GET)
    public String requestMethodName() {
        return "Hello World!";
    }
    
}
