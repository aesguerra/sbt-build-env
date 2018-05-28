package com.minyodev

import com.typesafe.config.ConfigFactory

object MainApp {

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()
    val env = config.getString("env")

    println(s"This package runs in $env")
  }
}
