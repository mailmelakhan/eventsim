package com.interana.eventsim

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.common.Uuid

import java.io.OutputStream
import scala.collection.mutable.ArrayBuffer

class KafkaOutputStream(val producer: KafkaProducer[Array[Byte],Array[Byte]], val topic: String) extends OutputStream {

  val buffer = new ArrayBuffer[Byte](4096)

  override def write(i: Int) = {
    buffer.append(i.toByte)
  }

  override def flush() = {
    val msg = new ProducerRecord[Array[Byte], Array[Byte]](topic, Uuid.randomUuid().toString.getBytes, buffer.toArray[Byte])
    producer.send(msg)
    buffer.clear()
  }

}
