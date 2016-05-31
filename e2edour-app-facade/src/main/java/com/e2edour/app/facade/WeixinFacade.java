package com.e2edour.app.facade;


import com.e2edour.app.facade.req.WeiXinReq;
import com.e2edour.app.facade.response.WeixinRes;

/**
 * 微信消息处理
 * @author King
 * @version 2016/5/30
 */
public interface WeixinFacade {

    String handlerMsg(WeiXinReq req);

    /**
     * 验签
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param signature  微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @return
     */
    boolean checkSignature(String timestamp,String nonce,String signature);
}
