package com.mulcahy.domain;

import java.util.Random;

/**
 * Created by Chris on 11/3/2016.
 */
public class PasswordGenerator {

    private static final char[] letters={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    private static Random r=new Random();


    public static int generate(){return r.nextInt(25);}


    public static String generatePassword(){
        String password="";
        for(int i=0;i<r.nextInt(8)+2;i++){
            password+=letters[generate()];
        }
        return password;
    }

}
