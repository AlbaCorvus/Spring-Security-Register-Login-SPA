package com.mulcahy.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris on 11/2/2016.
 */
public class RegisterHandler {


    private static final Map<String,Object> error;

    private String typeError="";

    static{
        Map<String,Object> initializeMap=new HashMap<String,Object>();
        initializeMap.put("RegisterError","Username invalid only characters A-Z and integers 0-9 allowed");
        initializeMap.put("Accepted","Registration complete, please check your email account for login details.");
        error= Collections.unmodifiableMap(initializeMap);
    }


    public RegisterHandler(String type){

        this.typeError=type;

    }

    public Object getMessage(){
        return error.get(typeError);
    }

}
