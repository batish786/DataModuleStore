package com.datamodulestore.spring.service;

import java.util.List;

import com.datamodulestore.spring.model.DataDetails;

public interface DataStoreService {

	public DataDetails fetchStoresCsvById(String storeId);
	
	public List<DataDetails> fetchAllStoresCsv(String parameter);
}
