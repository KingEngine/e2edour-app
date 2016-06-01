package com.e2edour.app.facade.response;

import com.e2edour.common.annotation.CDataAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;

/**
 * 微信回复消息
 *
 * @author King
 * @version 2016/5/30
 */
public class WeixinRes implements Serializable{

    private String toUserName;

    private String fromUserName;

    private long createTime;



    @XmlElement(name="CreateTime")
    public long getCreateTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    @XmlElement(name="FromUserName")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @XmlElement(name="ToUserName")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }


}
