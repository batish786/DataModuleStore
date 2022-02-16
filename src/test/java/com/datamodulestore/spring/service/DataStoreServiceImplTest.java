package com.datamodulestore.spring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.datamodulestore.spring.model.DataDetails;

@ExtendWith(MockitoExtension.class)
class DataStoreServiceImplTest {

	BufferedReader reader;
	
	@InjectMocks
	private DataStoreServiceImpl dataStoreServiceImpl;
	
	public DataStoreServiceImplTest() {
		reader = mock(BufferedReader.class);
		
	}
	
	@Test
	void testFetchStoresCsvById() {
		DataDetails dataDetails = new DataDetails();
		dataDetails.setStoreId("859aac4f-e34d-4392-aef7-9c0c14e49782");
		dataDetails.setCity("abc");
		dataDetails.setPostCode("dfsr555");
		
		assertEquals("859aac4f-e34d-4392-aef7-9c0c14e49782", dataStoreServiceImpl.fetchStoresCsvById("859aac4f-e34d-4392-aef7-9c0c14e49782").getStoreId());
		
		
	}

	@Test
	void testFetchAllStoresCsv() {
		
		DataDetails dataDetails = new DataDetails();
		dataDetails.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		dataDetails.setCity("abc");
		dataDetails.setPostCode("dfsr555");
		dataDetails.setOpenedDate(new Date());
		List<DataDetails> list = new ArrayList<>();
		list.add(dataDetails);
		String parameter="city";
		String storeId = dataStoreServiceImpl.fetchAllStoresCsv(parameter).get(0).getStoreId();
		System.out.println(storeId);
		assertEquals("1525eec4-7bed-4597-bf5a-e06fcede5f4f", dataStoreServiceImpl.fetchAllStoresCsv(parameter).get(0).getStoreId());
		
	}

}
