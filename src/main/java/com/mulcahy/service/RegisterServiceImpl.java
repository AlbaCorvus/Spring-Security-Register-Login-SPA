package com.mulcahy.service;

import com.mulcahy.dao.RegisterDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chris on 11/3/2016.
 */
@Service
public class RegisterServiceImpl implements RegisterService{


    private RegisterDao registerDao;

    public void setRegisterDao(RegisterDao registerDao){
        this.registerDao=registerDao;
    }

    @Transactional
    @Override
    public boolean checkRegisterUserName(String name) {
        return registerDao.checkRegisterUserName(name);
    }

    @Transactional
    @Override
    public void enterRegisterUserInfo(String name,String password,boolean b) {
        registerDao.enterRegisterUserInfo(name,password,b);
    }
}
