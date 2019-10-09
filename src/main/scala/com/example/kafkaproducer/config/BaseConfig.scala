package com.example.kafkaproducer.config

import com.typesafe.config.ConfigFactory

object BaseConfig {
  val config = ConfigFactory.load()

  val env = config.getString("app.env")
  val logLevel = config.getString("app.loglevel")

  val sslEnabled = config.getBoolean("feature.ssl")

  val pollInterval = config.getString("kafka.consumer.pollinterval").toInt
  val maxPollRecord = config.getString("kafka.max.poll.record")

  val bootStrapServers = config.getString("kafka.bootstrap.servers")
  val schemaRegistryUrl = config.getString("kafka.schemaregistry.servers")


  val sslPassword = config.getString("kafka.ssl.password")
  val sslTrustStoreLocation = config.getString("kafka.ssl.truststore.location")
  val sslTrustStorePassword = config.getString("kafka.ssl.truststore.password")

  val sslKeyStoreLocation = config.getString("kafka.ssl.keystore.location")
  val sslKeyStorePassword = config.getString("kafka.ssl.keystore.password")


}
