package com.e2edour.app.bot.router

import com.alibaba.fastjson.{JSONObject}
import com.turing.util._

/**
  * 图灵机器人
  *
  * @author King
  * @version 2016/5/20
  */
object TuringActor {

  def main(args: Array[String]) {
    Router.send("你知道图灵机器人吗？", "123456")
  }

}

object Router {

  def send(msg: String, userid: String): String = {
    val apiKey = "a7ab2971e79c5ed477482bdc6c581bda";
    //封装请求参数
    val replaceWord = "图灵机器人"
    val newWord = "小乐"
    val json = new JSONObject();
    json.put("key", apiKey);
    json.put("info", msg);
    json.put("userid", userid)
    //请求图灵api
    val result = PostServer.sendPost(json.toString(), "http://www.tuling123.com/openapi/api");
    println(result)
    val obj: TuringRes = TuringJsonUtil.parse(result)
    //判断code类型
    obj.getCode match {
      //文本类型需要将图灵替换为小乐
      case "100000" => obj.setText(obj.getText.replaceAll(replaceWord, newWord))
    }
    print(obj.getText)
    obj.getText
  }

}
