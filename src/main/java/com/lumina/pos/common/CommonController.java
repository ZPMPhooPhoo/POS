package com.lumina.pos.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/common")
public class CommonController {

    // error page 
    
    @RequestMapping(value = "/error", method=RequestMethod.GET)
    public String error() {
        return "error";
    }
    
}
