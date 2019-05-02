package com.gabrieldev.classes;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("rawtypes")
public class StudentDeserializer implements Deserializer{

	
	public void configure(Map configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	public Object deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		System.out.println("running custom deserializer");
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	    Object user = null;
	    try {
	    	user = mapper.readValue(data, Student.class);    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return user;
	}

	
	public void close() {
		// TODO Auto-generated method stub
		
	}



}
