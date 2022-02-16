package com.datamodulestore.spring.model;

import java.util.Date;
import lombok.Data;

@Data
public class DataDetails{

	private String StoreId;
	private String PostCode;
	private String City;
	private String Address;
	private Date OpenedDate;

	public String getStoreId() {
		return StoreId;
	}

	public void setStoreId(String storeId) {
		StoreId = storeId;
	}

	public String getPostCode() {
		return PostCode;
	}

	public void setPostCode(String postCode) {
		PostCode = postCode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getOpenedDate() {
		return OpenedDate;
	}

	public void setOpenedDate(Date openedDate) {
		OpenedDate = openedDate;
	}

	public DataDetails(String storeId, String postCode, String city, String address, Date openedDate) {
		super();
		StoreId = storeId;
		PostCode = postCode;
		City = city;
		Address = address;
		OpenedDate = openedDate;
	}

	public DataDetails() {
		super();
	}

	@Override
	public String toString() {
		return "DataDetails [StoreId=" + StoreId + ", PostCode=" + PostCode + ", City=" + City + ", Address=" + Address
				+ ", OpenedDate=" + OpenedDate + "]";
	}



}
