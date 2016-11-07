package com.mulcahy.dao;

import com.mulcahy.model.User;
import com.mulcahy.model.UserRole;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chris on 11/3/2016.
 */

@Repository
public class RegisterUserDaoImpl implements RegisterDao{

    private User u;

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean checkRegisterUserName(String name) {
        Session session=this.sessionFactory.getCurrentSession();
        List<User> user=session.createQuery("from User u where u.username ='"+name+"'").list();
        if(user.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public void enterRegisterUserInfo(String name,String password,boolean b) {

        Session session =this.sessionFactory.getCurrentSession();

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEnabled(b);

        session.save(user);


        session.save(new UserRole(name,"ROLE_ADMIN"));

    }
}
