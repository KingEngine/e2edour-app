package com.e2edour.app.dao.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 菜单导航栏
 * Created by King on 2015/9/13.
 */

@Document(collection = "navigation")
public class NavigationDO {

    @Id
    private String id;//主键
    @Field(value = "name")
    private String name;//菜单名称

    @Field(value = "code")
    private String code;//菜单值

    @Field(value = "url")
    private String url;//url

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
