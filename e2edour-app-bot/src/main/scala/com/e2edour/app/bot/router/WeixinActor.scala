package com.e2edour.app.bot.router


import com.e2edour.app.facade.req.WeiXinReq
import com.e2edour.app.facade.response.{WeixinRes, WexinTextRes}
import com.e2edour.common.utils.JaxbUtil
import com.wexin.WeiXinUtils
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

/**
  * 微信逻辑处理
  *
  * @author King
  * @version 2016/5/30
  */
@Service
class WeixinActor {

  val newWord = "小乐"

  val replaceWord = "图灵机器人"

  def hanlder(req: WeiXinReq): String = {

    val turlingRes = Router.sendTuring(req.getContent, req.getFromUserName)

    val res = new WeixinRes
    res.setToUserName(req.getToUserName)
    res.setFromUserName(req.getFromUserName)

    turlingRes.getCode match {
      case "100000" =>
        turlingRes.setText(turlingRes.getText.replaceAll(replaceWord, newWord))
        val textRes = new WexinTextRes
        BeanUtils.copyProperties(res, textRes)
        textRes.setContent(turlingRes.getText)
        val requestBinder = new JaxbUtil(classOf[WexinTextRes], classOf[JaxbUtil.CollectionWrapper])
        requestBinder.toXml(textRes)
      case _ =>
    }

  }

  def checkSignature(timestamp: String, nonce: String, signature: String): Boolean = {
    WeiXinUtils.checkSignature(timestamp, nonce, signature)
  }

}
