package com.lumina.pos.common;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/common")
public class CommonController {
 private static final Logger logger = (Logger) LoggerFactory.getLogger(CommonController.class);
   
 // error page 
    @RequestMapping(value = "/error", method=RequestMethod.GET)
    public String error() {
        logger.info("Error screen");
        return "error";
    }
    
}
