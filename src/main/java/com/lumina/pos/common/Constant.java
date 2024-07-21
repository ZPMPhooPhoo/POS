package com.lumina.pos.common;

import java.util.HashMap;

public class Constant {
      public static HashMap<String, String> gender() {
        HashMap<String, String> genderList = new HashMap<>();
        genderList.put("01", "Male");
        genderList.put("02", "Female");
        return genderList;
    }
    
}
