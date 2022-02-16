package com.datamodulestore.spring.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import com.datamodulestore.spring.exception.CustomException;
import com.datamodulestore.spring.model.DataDetails;
@Service
public class DataStoreServiceImpl implements DataStoreService{
	String line="";
	int count=0;

	@Override
	public DataDetails fetchStoresCsvById(String storeId){

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/stores.csv"));) {

			while((line=bufferedReader.readLine())!=null) {
				String[] data = line.split(",");
				if(data[0].equals(storeId)) {
					DataDetails dataDetails= new DataDetails();
					dataDetails.setStoreId(data[0]);
					dataDetails.setPostCode(data[1]);
					dataDetails.setCity(data[2]);
					dataDetails.setAddress(data[3]);
					dataDetails.setOpenedDate(new SimpleDateFormat("dd/MM/yyyy").parse(data[4]));
					count++;
					return dataDetails;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count>0)
			return  null;
		else 
			throw new CustomException("Put Valid Store Id");
	}

	@Override
	public List<DataDetails> fetchAllStoresCsv(String parameter) {
		
		try 
			(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/stores.csv"));){
				CSVParser parser = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
				List<DataDetails> list = new ArrayList<>();
				Iterable<CSVRecord> csvRecord = parser.getRecords();
				
				for (@SuppressWarnings("unused")
				CSVRecord csvRecordTwo:csvRecord){
					System.out.println("11");
					DataDetails storeDto = new DataDetails();
					storeDto.setStoreId(csvRecordTwo.get("Store Id"));
					storeDto.setPostCode(csvRecordTwo.get("Post Code"));
					storeDto.setCity(csvRecordTwo.get("City"));
					storeDto.setAddress(csvRecordTwo.get("Address"));
					System.out.println("11");
					storeDto.setOpenedDate(new SimpleDateFormat("dd/MM/yyyy").parse(csvRecordTwo.get("opened Date")));
					list.add(storeDto);
				}
				System.out.println("1");
				if (parameter.equalsIgnoreCase("city")) {
					return list.stream().sorted(Comparator.comparing(DataDetails::getCity)).collect(Collectors.toList());
				} else if (parameter.equalsIgnoreCase("date")) {
					return list.stream().sorted(Comparator.comparing(DataDetails::getOpenedDate))
							.collect(Collectors.toList());
				}
			
				return null;	
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw new CustomException("put proper parameter"); 
	}
}
