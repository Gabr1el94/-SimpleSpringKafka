/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrieldev.application;

import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.gabrieldev.classes.Student;

/**
 *
 * @author gabrieldev
 */
public class ConsumerApplication {
    public static void main(String[] args) {
        	
		String topic= "testProducer";
		
		Properties prop = new Properties(); 
		prop.put("bootstrap.servers", "0.0.0.0:9092");
		prop.put("key.deserializer", "com.gabrieldev.classes.StudentDeserializer");
		prop.put("value.deserializer", "com.gabrieldev.classes.StudentDeserializer");
        prop.put("auto.offset.reset","earliest");
        prop.put("group.id","group_text");
        
        try (KafkaConsumer<byte[], Object> consumer = new KafkaConsumer<>(prop)) {
            consumer.subscribe(Collections.singletonList(topic));
                ConsumerRecords<byte[], Object> messages = consumer.poll(100);
                for (ConsumerRecord<byte[], Object> message : messages) {
	        	    	if (message.value() != null) {
	        	    		Student user = (Student) message.value();
	        	    		System.out.println("user.id: "+user.getId());
	        		    	System.out.println("user.nome: "+user.getNome());	
	        	    	}
                	
                     System.out.println("TESTE:"+message.value().toString());
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
