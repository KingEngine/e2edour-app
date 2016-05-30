package com.e2edour.app.bot.router

import akka.actor.Actor
import com.e2edour.app.facade.req.WeiXinReq
import com.e2edour.app.facade.response.WeixinRes
import com.wexin.WeiXinUtils
import org.springframework.stereotype.Service

/**
  *
  *
  * @author King
  * @version 2016/5/30
  */
@Service
class WeixinActor{


  def hanlder(req: WeiXinReq): WeixinRes = {
    //判断是否微信发送过来的消息正确

    //判断消息类型是否支持
    val turlingRes = Router.send(req.getContent, req.getFromUserName)

    new WeixinRes
  }

  def checkSignature(timestamp: String, nonce: String, signature: String): Boolean = {
    WeiXinUtils.checkSignature(timestamp, nonce,signature)
  }

}
