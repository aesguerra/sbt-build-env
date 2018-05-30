package com.minyodev

import com.typesafe.config.ConfigFactory

object MainApp {

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()
    val foo = config.getString("minyodev.message")

    println(s"Message $foo")
    println("Some foo: " + config.getString("some-foo"))
  }
}
