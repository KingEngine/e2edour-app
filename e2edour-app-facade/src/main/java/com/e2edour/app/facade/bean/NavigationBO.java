package com.e2edour.app.facade.bean;

import java.io.Serializable;

/**
 * Created by King on 2015/9/13.
 */
public class NavigationBO implements Serializable {

    private static final long serialVersionUID = 5732212734350861170L;

    private String id;

    private String name;

    private String code;

    private String url;

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
