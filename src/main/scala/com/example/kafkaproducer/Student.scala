package com.example.kafkaproducer

case class Student(name:String , cwid:String , level:String , addresses:List[Address], phoneNumber:Option[Int])

case class Address(houseNumber:Int , streetName:String , city:String , state:String)