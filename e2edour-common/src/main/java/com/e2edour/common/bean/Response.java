package com.e2edour.common.bean;

import java.io.Serializable;

/**
 * Created by King on 2015/9/30.
 */
public class Response implements Serializable {

    private String code;

    private String desc;

    public Response(String code, String desc) {
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
