package com.housepredict.service;
import java.util.*;
import com.housepredict.model.CityMasterModel;
import com.housepredict.repository.CityRepository;

public class CityServices {
	CityRepository cityRepo=new CityRepository();
	public boolean isAddCity(CityMasterModel model)
	{
		return cityRepo.isAddCity(model);
	}
	
	public List<CityMasterModel> getAllCities()
	{
		return cityRepo.getAllCities();
	}
	public int getCityIdByName(String cityName)
	{
		return cityRepo.getCityIdByName(cityName);
	}

}
