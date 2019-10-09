package com.example.kafkaproducer

import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object SimpleKafkaProducer extends App with LazyLogging {

  val numberOfRecords = 1
  val topicName = "university.student.dev.v1.avro"

  val data = createStudentData()
  recordProducer(1,"My name is Jon" , topicName)

  def createStudentData(): Student = {
    new Student(
      name = "Jon",
      cwid = "A20351000",
      level = "Graduate",
      addresses = List(),
      phoneNumber = None
    )

  }


  def recordProducer(numberOfRecords: Int, data: String, topic: String) = {
    val producer = new KafkaProducer[Nothing, String](ProducerProperties.buildProducerProperties)

    for (i <- 1 to numberOfRecords) {
      val record = new ProducerRecord(topic, data)
      val recordMetadata = producer.send(record).get()
      logger.info(s"Produced records at offset ${recordMetadata.offset} of partition: ${recordMetadata.partition} at ${recordMetadata.timestamp()}")

    }
  }


}
