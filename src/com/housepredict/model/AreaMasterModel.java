package com.housepredict.model;

public class AreaMasterModel extends CityMasterModel {
	// area is in city what means to extends citymaster is parent here
	// all citymaster properties are inherited by areamastermodel
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	private String areaname;

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	private String pincode;
}
