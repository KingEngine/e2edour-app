package com.e2edour.app.facade.response;

/**
 * Created by King on 2015/11/12.
 */
public class CommonResponse implements java.io.Serializable {

    private String resCode;

    private String resMsg;

    private Object obj;


    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
