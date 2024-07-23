package com.lumina.pos.common;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lumina.pos.service.UserService;

import ch.qos.logback.classic.Logger;


@Controller
public class CommonController {
 private static final Logger logger = (Logger) LoggerFactory.getLogger(CommonController.class);
   

    @Autowired
    private UserService userService;
 // error page 
    @RequestMapping(value = "/error", method=RequestMethod.GET)
    public String error() {
        logger.info("Error screen");
        return "error";
    }


    @RequestMapping(value="/checkEmail", method=RequestMethod.GET)
    public @ResponseBody Boolean checkEmail(@RequestParam(name = "email") String email) {
       try{
          logger.info("email : "+email);
          boolean delFlag=false;
          Boolean result = userService.checkUser(email, delFlag);
        if (result != null && result) {
             logger.info("email : "+email +" is check");
            return true;
          }
        return false;
       }catch (Exception e){
        logger.warn("Invalid email "+e.getMessage());
        return false;
       }
    }
    
    
}
