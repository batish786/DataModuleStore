package com.datamodulestore.spring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.datamodulestore.spring.model.DataDetails;
import com.datamodulestore.spring.service.DataStoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DataStoreControllerTest {

	@MockBean
	private DataStoreService dataStoreService;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext applicationContext;
	ObjectMapper mapper = new ObjectMapper();
	
	@BeforeEach
	void setUp() throws Exception {
		mockMvc= MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	void testFetchCvsById() throws UnsupportedEncodingException,Exception {
		
		DataDetails dataDetails = new DataDetails();
		dataDetails.setStoreId("5");
		dataDetails.setPostCode("4654165");
		dataDetails.setCity("Bengaluru");
		
		when(dataStoreService.fetchStoresCsvById(Mockito.anyString())).thenReturn(dataDetails);
		
		String contentAsString=mockMvc.perform(get("/5").content(mapper.writeValueAsString(dataDetails))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(mapper.writeValueAsString(dataDetails),contentAsString);	
		
	}

	@Test
	void testFetchAll() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		List<DataDetails> list = new ArrayList<>();
		
		DataDetails dataDetails = new DataDetails();
		list.add(dataDetails);
		
		when(dataStoreService.fetchAllStoresCsv(Mockito.any())).thenReturn(list);
		
		String contentAsString = mockMvc.perform(get("/fetchAll/city").content(mapper.writeValueAsString(list))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(mapper.writeValueAsString(list), contentAsString);
		
	}

}
