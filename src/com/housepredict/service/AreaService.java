package com.housepredict.service;

import java.util.List;

import com.housepredict.model.AreaMasterModel;
import com.housepredict.repository.AreaRepository;

public class AreaService 
{
	AreaRepository areaRepo=new AreaRepository();
	
	public boolean isAddNewArea(AreaMasterModel model)
	{
	return 	areaRepo.isAddNewArea(model);
	}
	
	public List<AreaMasterModel> getCityByAreaName()
	{
		return areaRepo.getCityByAreaName();
	}
	
	public List<String> areaList(int cityId) {
		return areaRepo.areaList(cityId);
	}
	
	
	public int getAreaIdByName(String AreaName) {
		return areaRepo.getAreaIdByName(AreaName);
	}
}
