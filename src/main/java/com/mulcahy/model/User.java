package com.mulcahy.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User{

    @Id
    @Column(name="username")
    private String username;

    private String password;

    private boolean enabled;

    /*getters and setters */

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public User(){

    }

    public User(String name,String password,boolean b){
        this.username=name;
        this.password=password;
        this.enabled=b;
    }

}