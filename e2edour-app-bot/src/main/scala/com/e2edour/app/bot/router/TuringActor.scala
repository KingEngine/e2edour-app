package com.e2edour.app.bot.router

import com.alibaba.fastjson.JSONObject
import com.e2edour.common.utils.SendUtil
import com.turing.util._
import org.slf4j.{Logger, LoggerFactory}

/**
  * 图灵机器人
  *
  * @author King
  * @version 2016/5/20
  */
object TuringActor {

  private val logger: Logger = LoggerFactory.getLogger(getClass)

  val apiKey = "a7ab2971e79c5ed477482bdc6c581bda";

  def send(msg: String, userid: String): Option[TuringRes] = {

    val json = new JSONObject();
    json.put("key", apiKey);
    json.put("info", msg);
    json.put("userid", userid)

    logger.info(s"---------------chat [$userid] dialog---------------------")
    logger.info(s"[$userid] ask :[$msg]")
    //模式匹配
    msg match {
      case "网易新闻" =>
        val res = new TuringRes;
        res.setUrl("http://3g.163.com");
        res.setCode(TuringTypeCode.type_200000)
        res.setText("新闻")
        Some(res)
      case _ =>
        val result = SendUtil.sendPost("http://www.tuling123.com/openapi/api", json.toString())
        logger.info(s"[turling] answer :[$result]")
        val obj: TuringRes = TuringJsonUtil.parse(result)
        Some(obj)
    }

  }
}

object Router {

  def sendTuring(msg: String, userid: String): Option[TuringRes] = {
    TuringActor.send(msg, userid)
  }

}
