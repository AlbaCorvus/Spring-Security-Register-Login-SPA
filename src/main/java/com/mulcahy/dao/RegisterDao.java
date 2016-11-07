package com.mulcahy.dao;

/**
 * Created by Chris on 11/3/2016.
 */
public interface RegisterDao {

    public boolean checkRegisterUserName(String name);

    public void enterRegisterUserInfo(String name,String password,boolean b);


}
