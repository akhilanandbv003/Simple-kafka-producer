name := "Simple-kafka-producer"

version := "0.1"

scalaVersion := "2.12.8"

val confluent = "3.3.1"
val kafka = "0.11.0.1"

resolvers ++= Seq(
  "Confluent Maven Repo" at "http://packages.confluent.io/maven/"
)

libraryDependencies ++= {
  Seq(
    "io.confluent" % "kafka-avro-serializer" % confluent,
    "io.confluent" % "kafka-json-serializer" % confluent,
    "com.typesafe" % "config" % "1.3.4", // To read from app.conf

    "org.apache.kafka" %% "kafka" % kafka // Versions need to match with kafka, scala and build.properties or else we will get sbt download errors

  ).map(_.exclude("org.slf4j", "*"))
}

libraryDependencies ++= {
  Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3"
  )
}