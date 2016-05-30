package com.e2edour.app.facade;


import com.e2edour.app.facade.req.WeiXinReq;
import com.e2edour.app.facade.response.WeixinRes;

/**
 * 微信消息处理
 * @author King
 * @version 2016/5/30
 */
public interface WeixinFacade {

    WeixinRes handlerMsg(WeiXinReq req);

    boolean checkSignature(String signature,String timestamp,String nonce,String echostr);
}
