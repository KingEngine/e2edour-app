package com.e2edour.app.facade.bean;

/**
 * Created by King on 2015/11/12.
 */
public enum RspCode {

    success("000000", "成功"),

    error("E00001", "失败");

    private String code;

    private String desc;

    RspCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
