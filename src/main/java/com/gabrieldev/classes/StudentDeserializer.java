package com.gabrieldev.classes;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("rawtypes")
public class StudentDeserializer implements org.apache.kafka.common.serialization.Deserializer{

	@Override
	public void configure(Map configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
	    ObjectMapper mapper = new ObjectMapper();
	    String user = null;
	    try {
	      user = mapper.readValue(data, String.class);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return user;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}



}
