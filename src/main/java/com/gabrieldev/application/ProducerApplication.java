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
import org.springframework.util.SerializationUtils;

import com.gabrieldev.classes.Student;

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

        try (Producer<String,Student> producer = new KafkaProducer<>(prop)) {
        		   Student s = new Student();
        		   s.setId(1);
        		   s.setNome("Gabriel Soares");
                   producer.send(new ProducerRecord<>(topicName,s));	   
        } catch (Exception e) {
                   e.printStackTrace();
        }
    }
}
