package com.e2edour.app.service;

import com.e2edour.app.bot.router.WeixinActor;
import com.e2edour.app.facade.WeixinFacade;
import com.e2edour.app.facade.req.WeiXinReq;
import com.e2edour.app.facade.response.WeixinRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author King
 * @version 2016/5/30
 */
@Service("weixinService")
public class WeixinServiceImpl implements WeixinFacade {

    @Autowired
    private WeixinActor weixinActor;

    @Override
    public WeixinRes handlerMsg(WeiXinReq req) {
        return null;
    }

    @Override
    public boolean checkSignature(String timestamp,String nonce,String signature) {
        return weixinActor.checkSignature(timestamp, nonce, signature);
    }
}
