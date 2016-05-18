package com.e2edour.common.bean;

/**
 * Created by King on 2015/11/19.
 */
public enum TopicsChannel {
    Customer("Customer","会员投稿"),
    Admin("Admin","管理员发布"),
    Fetcher("Fetcher","爬虫引擎");

    private String code;

    private String desc;

    TopicsChannel(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
