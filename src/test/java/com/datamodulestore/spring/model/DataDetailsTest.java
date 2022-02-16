package com.datamodulestore.spring.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class DataDetailsTest {

	String json = "{\"address\":\"btm\",\"storeId\":\"10\",\"postCode\":\"45755\",\"city\":\"bengaluru\",\"openedDate\":null}";
			

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void SerializationTest() throws JsonProcessingException, ParseException {
		DataDetails dataDetails = new DataDetails();
		dataDetails.setStoreId("10");
		dataDetails.setPostCode("45755");
		dataDetails.setCity("bengaluru");
		dataDetails.setAddress("btm");
		
	  assertEquals("10", objectMapper.readValue(json, DataDetails.class).getStoreId());
	}
	
	@Test
	  public void deserlizationTest() throws JsonMappingException,JsonProcessingException{
		  DataDetails readvalue=objectMapper.readValue(json, DataDetails.class);
		  assertEquals("10", readvalue.getStoreId());
	  }
	  
	  
	}


