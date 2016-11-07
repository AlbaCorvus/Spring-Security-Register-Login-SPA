package com.mulcahy.service;

/**
 * Created by Chris on 11/3/2016.
 */
public interface RegisterService {

    public boolean checkRegisterUserName(String name);

    public void enterRegisterUserInfo(String name,String password,boolean b);

}
