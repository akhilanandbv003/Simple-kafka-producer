package com.example.kafkaproducer.utils

import java.nio.file.{Files, Paths}

import scala.io.{BufferedSource, Source}

trait FileUtils {

  /**
    * fileName should be
    *
    */
  def readFromFile(fileName: String): String = {
    new String(Files.readAllBytes(Paths.get(fileName)))
  }

  def readFromBufferedSource(fileName: String): String = {
    val buffer: BufferedSource = Source.fromFile(getClass.getClassLoader.getResource(fileName).getPath)
    val message = buffer.getLines.mkString
    buffer.close()

    message
  }

}
