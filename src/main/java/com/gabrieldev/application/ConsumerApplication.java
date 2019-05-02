/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrieldev.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author gabrieldev
 */
public class ConsumerApplication {
    public static void main(String[] args) {
        	
		String topic= "testProducer";
		
		Properties prop = new Properties(); 
		prop.put("bootstrap.servers", "localhost:9092");
		prop.put("key.deserializer", "com.gabrieldev.classes.StudentDeserializer");
		prop.put("value.deserializer", "com.gabrieldev.classes.StudentDeserializer");
        prop.put("auto.offset.reset","earliest");
        prop.put("group.id","group_text");
        
        try (KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(prop)) {
            consumer.subscribe(Collections.singletonList(topic));
                
		ConsumerRecords<String, byte[]> messages = consumer.poll(100);
                for (ConsumerRecord<String, byte[]> message : messages) {
                    try {
                        String msg = new String(message.value());
                        System.out.println("Message received:" + msg.toString());
                    } catch (Exception e) {
                       e.printStackTrace();
                    }
                }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
