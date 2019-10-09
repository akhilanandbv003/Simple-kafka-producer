package com.example.kafkaproducer

import java.util.Properties

import com.example.kafkaproducer.config.BaseConfig
import org.apache.kafka.clients.producer.ProducerConfig._
import org.apache.kafka.common.serialization.StringSerializer
import io.confluent.kafka.serializers.{KafkaAvroSerializer, KafkaJsonSerializer}
import org.apache.kafka.clients.CommonClientConfigs

object ProducerProperties {

  def buildProducerProperties:Properties ={

    val props = new Properties()
    props.put(BOOTSTRAP_SERVERS_CONFIG,BaseConfig.bootStrapServers)
    props.put(KEY_SERIALIZER_CLASS_CONFIG,classOf[StringSerializer])
    props.put(VALUE_SERIALIZER_CLASS_CONFIG,classOf[KafkaJsonSerializer[Student]]) //KafkaJsonSerializer needs a type Parameter
//    props.put(VALUE_SERIALIZER_CLASS_CONFIG,classOf[KafkaAvroSerializer])
//    props.put(VALUE_SERIALIZER_CLASS_CONFIG,classOf[StringSerializer])
    props.put("schema.registry.url",BaseConfig.schemaRegistryUrl)

    if(BaseConfig.sslEnabled){
      props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG,"SSL")
    }
    props
  }

}
