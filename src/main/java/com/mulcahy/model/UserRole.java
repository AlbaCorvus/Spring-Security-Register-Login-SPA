package com.mulcahy.model;

import javax.persistence.*;

/**
 * Created by Chris on 11/3/2016.
 */

@Entity
@Table(name="user_roles")
public class UserRole {

    @Id
    @Column(name="user_role_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String role;

    public UserRole(){

    }

    public UserRole(String name,String role){
        this.username=name;
        this.role=role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
