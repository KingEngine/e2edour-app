package com.e2edour.app.dao.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 会员操作
 */
@Document(collection = "customer")
public class CustomerDO {

    @Id
    private String id;

    @Field("customer_name")
    @Indexed(unique = true)
    private String name;//用户名

    @Field("customer_pwd")
    private String password;//用户密码

    @Field("customer_email")
    @Indexed(unique = true)
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
