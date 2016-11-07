package com.mulcahy.dao;

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
public class RegisterDaoImplTest {


    @Autowired
    private RegisterDao registerDao;

    private User user;


    @Before
    public void initUser(){
        user = new User("Chris","1234",true);
    }


    @Test
    @Transactional
    @Rollback(true)
    public void AddRegisterUserTest(){
        registerDao.enterRegisterUserInfo(user.getName(),user.getPassword(),user.isEnabled());
        Assert.assertEquals(false,registerDao.checkRegisterUserName(user.getName()));
        Assert.assertEquals(true,registerDao.checkRegisterUserName("test"));
    }




}
