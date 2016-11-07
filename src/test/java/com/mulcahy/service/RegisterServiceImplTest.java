package com.mulcahy.service;

import com.mulcahy.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Chris on 11/4/2016.
 */

@ContextConfiguration("classpath:appContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RegisterServiceImplTest {


    @Autowired
    RegisterService registerService;

    private User user;

    @Before
    public void intiUser(){
        user= new User("Chris","1234",true);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void registryServiceTest(){

        registerService.enterRegisterUserInfo(user.getName(),user.getPassword(),user.isEnabled());
        Assert.assertEquals(true,registerService.checkRegisterUserName("testfortrue"));
        Assert.assertEquals(false,registerService.checkRegisterUserName(user.getName()));

    }


}
