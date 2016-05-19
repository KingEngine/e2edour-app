//package com.e2edour.app.bot.router
//
//import java.io.{InputStreamReader, BufferedReader}
//import java.net.{UnknownHostException, URL, HttpURLConnection}
//
//import scala.io.Source
//import scala.util.parsing.json.JSON
//
///**
// * Created by King on 2015/12/4.
// */
//object Router {
//
//  val url = "http://www.tuling123.com/openapi/api?key=a7ab2971e79c5ed477482bdc6c581bda&loc=UTF-8&info="
//
//  def send(messge: String): Unit = {
//    val sendMsg = url + messge;
//    val requestURL = new URL(sendMsg)
//    val connection = requestURL.openConnection.asInstanceOf[HttpURLConnection]
//    connection.setRequestMethod("GET")
//    connection.setDoOutput(true);
//    connection.setDoInput(true);
//    connection.setUseCaches(false);
//    val buffer = new StringBuffer
//    try {
//      val input = connection.getInputStream
//
//      for (line <- Source.fromInputStream(input).getLines) {
//        buffer.append(line)
//      }
//    }
//    catch {
//      case e: UnknownHostException =>
//        print(e.getMessage)
//    }
//    val data = JSON.parseFull(buffer.toString)
//    //val result = Some(data)
//    //data.
//    print(data)
//    data match {
//      case _ =>
//    }
//    buffer.toString
//  }
//
//  def main(args: Array[String]) {
//    print(send("你好"))
//  }
//}
