package com.e2edour.app.bot.router

import akka.actor.Actor
import com.alibaba.fastjson.JSONObject
import com.turing.util._

/**
  * 图灵机器人
  *
  * @author King
  * @version 2016/5/20
  */
object TuringActor {

  def send(msg: String, userid: String): TuringRes = {
    val apiKey = "a7ab2971e79c5ed477482bdc6c581bda";
    val json = new JSONObject();
    json.put("key", apiKey);
    json.put("info", msg);
    json.put("userid", userid)
    //请求图灵api
    val result = PostServer.sendPost(json.toString(), "http://www.tuling123.com/openapi/api");
    val obj: TuringRes = TuringJsonUtil.parse(result)
    //判断code类型
    obj
  }
}

object Router {

  def sendTuring(msg: String, userid: String): TuringRes = {
    TuringActor.send(msg, userid)
  }

}
