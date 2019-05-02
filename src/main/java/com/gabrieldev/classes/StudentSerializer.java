package com.gabrieldev.classes;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("rawtypes")
public class StudentSerializer implements Serializer{

	@Override
	public void configure(Map configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String topic, Object data) {
		// TODO Auto-generated method stub
		System.out.println("running custom serializer");
		System.out.println("data: "+ data);
	    byte[] retVal = null;
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	      retVal = objectMapper.writeValueAsString(data).getBytes();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return retVal;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	
}
