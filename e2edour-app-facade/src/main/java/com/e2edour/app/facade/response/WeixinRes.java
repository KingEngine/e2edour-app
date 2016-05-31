package com.e2edour.app.facade.response;

import com.e2edour.app.facade.annotation.CDataAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * 微信回复消息
 *
 * @author King
 * @version 2016/5/30
 */
public class WeixinRes implements Serializable{

    private String toUserName;

    private String fromUserName;

    private String createTime;




    @XmlElement(name="CreateTime")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
