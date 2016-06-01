package com.e2edour.app.bot.router


import java.util

import com.e2edour.app.facade.req.WeiXinReq
import com.e2edour.app.facade.response.WeixinNewsRes.Item
import com.e2edour.app.facade.response.{WeixinNewsRes, WeixinRes, WeixinTextRes}
import com.e2edour.common.utils.JaxbUtil
import com.turing.util.TuringTypeCode
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
      //文本类
      case TuringTypeCode.type_100000 =>
        implicit val textRes = new WeixinTextRes
        BeanUtils.copyProperties(weixinRes, textRes)
        textRes.setContent(turlingRes.getText.replaceAll(replaceWord, newWord))
        parseWeixinRes
      //链接类
      case TuringTypeCode.type_200000 =>
        implicit val newsRes = new WeixinNewsRes
        BeanUtils.copyProperties(weixinRes, newsRes)
        newsRes.setArticleCount(1)
        val item = new Item
        val items = new util.ArrayList[Item]()
        items.add(item)
        item.setTitle(turlingRes.getText)
        item.setUrl(turlingRes.getUrl)
        newsRes.setItems(items)
        parseWeixinRes
      //新闻类
      case TuringTypeCode.type_302000 =>
        implicit val newsRes = new WeixinNewsRes
        BeanUtils.copyProperties(weixinRes, newsRes)
        newsRes.setArticleCount(turlingRes.getList.size())
        val items = new util.ArrayList[Item]()
        for (i <- 0 to turlingRes.getList.size() - 1) {
          val item = new Item
          val news = turlingRes.getList.get(i)
          item.setTitle(news.getArticle)
          item.setUrl(news.getDetailurl)
          item.setPicUrl(news.getIcon)
          item.setDescription(news.getSource)
          items.add(item)
        }
        newsRes.setItems(items)
        parseWeixinRes
      //菜谱
      case TuringTypeCode.type_308000 =>
        implicit val newsRes = new WeixinNewsRes
        BeanUtils.copyProperties(weixinRes, newsRes)
        newsRes.setArticleCount(turlingRes.getList.size())
        val items = new util.ArrayList[Item]()
        for (i <- 0 to turlingRes.getList.size() - 1) {
          val item = new Item
          val news = turlingRes.getList.get(i)
          item.setTitle(news.getName)
          item.setUrl(news.getDetailurl)
          item.setPicUrl(news.getIcon)
          item.setDescription(news.getInfo)
          items.add(item)
        }
        newsRes.setItems(items)
        parseWeixinRes
      case _ =>
        implicit val textRes = new WeixinTextRes
        BeanUtils.copyProperties(weixinRes, textRes)
        textRes.setContent("亲爱的，不明白你说的什么意思。")
        parseWeixinRes
    }

  }

  def parseWeixinRes(implicit newsRes: WeixinRes): String = {
    val requestBinder = new JaxbUtil(newsRes.getClass, classOf[JaxbUtil.CollectionWrapper])
    requestBinder.toXml(newsRes)
  }

  def checkSignature(timestamp: String, nonce: String, signature: String): Boolean = {
    WeiXinUtils.checkSignature(timestamp, nonce, signature)
  }

}
