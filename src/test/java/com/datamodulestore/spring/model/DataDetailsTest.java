package com.datamodulestore.spring.model;

import java.text.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class DataDetailsTest {

	String json = "{\"address\":\"btm\",\"storeId\":\"10\",\"postCode\":\"45755\",\"openedDate\":1644990723521,\"city\":\"bengaluru\"}";

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void SerializationTest() throws JsonProcessingException, ParseException {
//		DataDetails dataDetails = new DataDetails();
//		dataDetails.setStoreId("10");
//		dataDetails.setPostCode("45755");
//		dataDetails.setCity("bengaluru");
//		dataDetails.setAddress("btm");
//		dataDetails.setOpenedDate(new SimpleDateFormat("dd/MM/yyyy").parse("12/10/1997"));
//		
//		
//		System.out.println(objectMapper.writeValueAsString(dataDetails);
		
	  DataDetails readvalue=objectMapper.readValue(json, DataDetails.class);
	  assertEquals(json, objectMapper.writeValueAsString(readvalue));
	}
	
	@Test
	  public void deserlizationTest() throws JsonMappingException,JsonProcessingException{
		  DataDetails readvalue=objectMapper.readValue(json, DataDetails.class);
		  assertEquals(json, objectMapper.writeValueAsString(readvalue));
	  }
	  
	  
	}


