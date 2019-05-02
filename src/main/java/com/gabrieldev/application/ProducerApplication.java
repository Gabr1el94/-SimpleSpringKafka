/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrieldev.application;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author gabrieldev
 */
public class ProducerApplication {
    public static void main(String[] args) {
        String topicName="testProducer";
		
        Properties prop =  new Properties();
        prop.put("bootstrap.servers", "localhost:9092");
        prop.put("key.serializer", "com.gabrieldev.classes.StudentSerializer");
        prop.put("value.serializer", "com.gabrieldev.classes.StudentSerializer");
        prop.put("client.id","simpleProducer");
        prop.put("retries", 1);

        try (Producer<byte[], byte[]> producer = new KafkaProducer<>(prop)) {
                   producer.send(new ProducerRecord<>(topicName, "Gabriel Soares".getBytes()));	   
        } catch (Exception e) {
                   e.printStackTrace();
        }
    }
}
