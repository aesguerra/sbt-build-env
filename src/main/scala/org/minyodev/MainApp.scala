package org.minyodev

import com.typesafe.config.ConfigFactory

object MainApp {

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()

    println(s"Message ${config.getString("minyodev.message")}")
    println(s"Some foo: ${config.getString("some-foo")}")

    import collection.JavaConversions._
    val myList = config.getStringList("fruits").toList
    println("Config list: " + myList.mkString(","))


  }
}
