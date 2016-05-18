package com.e2edour.app.facade.bean;



import java.io.Serializable;

/**
 * Created by King on 2015/12/21.
 */
public class CustomerBO implements Serializable {

    private String id;

    private String name;//用户名

    private String password;//用户密码

    private String email;//用户邮箱

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
