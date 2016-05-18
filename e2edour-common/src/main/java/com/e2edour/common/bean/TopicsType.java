package com.e2edour.common.bean;

/**
 * Created by King on 2015/11/19.
 */
public enum TopicsType {

    Text("Text","文字笑话"),
    Img("Img","图片笑话");

    private String code;

    private String desc;

    TopicsType(String code, String desc) {
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
