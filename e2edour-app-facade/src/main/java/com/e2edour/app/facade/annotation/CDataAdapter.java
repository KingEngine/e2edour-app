package com.e2edour.app.facade.annotation;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author King
 * @version 2016/5/31
 */
public class CDataAdapter extends XmlAdapter<String, String> {

//从javabean到xml的适配方法

    @Override
    public String marshal(String msg) throws Exception {
        return "<![CDATA[" + msg + "]]>";
    }


    //从xml到javabean的适配方法
    @Override
    public String unmarshal(String msg) throws Exception {
        return msg;
    }
}