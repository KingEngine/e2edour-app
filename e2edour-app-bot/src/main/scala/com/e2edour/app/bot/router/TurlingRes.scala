package com.e2edour.app.bot.router

import java.util

import scala.beans.BeanProperty

/**
  *
  *
  * @author King
  * @version 2016/5/20
  */

class TuringRes {

  @BeanProperty var code = ""

  @BeanProperty var text = ""

  @BeanProperty var url = ""

  @BeanProperty var list = new util.ArrayList[News]()


}

class News {

  @BeanProperty var article = ""
  @BeanProperty var source = ""
  @BeanProperty var icon = ""
  @BeanProperty var detailurl = ""

}
