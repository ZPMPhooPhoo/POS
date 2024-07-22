package com.lumina.pos.common;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;


@Controller
public class CommonController {
 private static final Logger logger = (Logger) LoggerFactory.getLogger(CommonController.class);
   
 // error page 
    @RequestMapping(value = "/error", method=RequestMethod.GET)
    public String error() {
        logger.info("Error screen");
        return "error";
    }


    @RequestMapping(value="/checkEmail", method=RequestMethod.GET)
    public String requestMethodName(@RequestParam(name = "email") String email) {
       try{
        logger.debug("email"+email);
        boolean delFlag=false;

       }catch (Exception e){

       }
        return new String();
    }
    
    
}
