package com.datamodulestore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.datamodulestore.spring.model.DataDetails;
import com.datamodulestore.spring.service.DataStoreService;

@RestController
public class DataStoreController {

	@Autowired
	private DataStoreService dataStoreService;

	@GetMapping("/{StoreId}")
	public ResponseEntity<?> fetchCvsById(@PathVariable String StoreId) {
		DataDetails StoreById = dataStoreService.fetchStoresCsvById(StoreId);
		if(StoreById!=null) 
			return new ResponseEntity<>(StoreById, HttpStatus.OK);
		else
			return new ResponseEntity<>("successfully not fetch", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/fetchAll/{parameter}")
	public ResponseEntity<?> fetchAll(@PathVariable String parameter){
		List<DataDetails> fetchByCity = dataStoreService.fetchAllStoresCsv(parameter);
		if(!fetchByCity.isEmpty()) {
			return new ResponseEntity<>(fetchByCity, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		}
	}


}


