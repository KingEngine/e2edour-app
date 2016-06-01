package com.e2edour.app.facade.response;

import com.e2edour.common.annotation.CDataAdapter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author King
 * @version 2016/5/31
 */
@XmlType
@XmlRootElement(name="xml")
public class WexinTextRes extends WeixinRes {

    private String content;


    private String msgType;

    @XmlElement(name="Content")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement(name="MsgType")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    public String getMsgType() {
        return "text";
    }
}
