package com.e2edour.app.bot.router


import java.util

import com.e2edour.app.facade.req.WeiXinReq
import com.e2edour.app.facade.response.WeixinNewsRes.Item
import com.e2edour.app.facade.response.{WeixinNewsRes, WeixinRes, WeixinTextRes}
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

    val weixinRes = new WeixinRes
    weixinRes.setToUserName(req.getFromUserName)
    weixinRes.setFromUserName(req.getToUserName)

    turlingRes.getCode match {
      case "100000" =>
        turlingRes.setText(turlingRes.getText.replaceAll(replaceWord, newWord))
        val textRes = new WeixinTextRes
        BeanUtils.copyProperties(weixinRes, textRes)
        textRes.setContent(turlingRes.getText)
        val requestBinder = new JaxbUtil(classOf[WeixinTextRes], classOf[JaxbUtil.CollectionWrapper])
        requestBinder.toXml(textRes)
      case "200000" =>
        val newsRes = new WeixinNewsRes
        BeanUtils.copyProperties(weixinRes, newsRes)
        newsRes.setArticleCount(1)
        val item = new Item
        val items = new util.ArrayList[Item]()
        items.add(item)
        item.setTitle(turlingRes.getText)
        item.setUrl(turlingRes.getUrl)
        newsRes.setItems(items)
        val requestBinder = new JaxbUtil(classOf[WeixinNewsRes], classOf[JaxbUtil.CollectionWrapper])
        requestBinder.toXml(newsRes)
      case _ => ""
    }

  }

  def checkSignature(timestamp: String, nonce: String, signature: String): Boolean = {
    WeiXinUtils.checkSignature(timestamp, nonce, signature)
  }

}
