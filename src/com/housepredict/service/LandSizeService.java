package com.housepredict.service;

import com.housepredict.model.LandSizeModel;
import com.housepredict.repository.LandSizeRepository;

public class LandSizeService 
{
	LandSizeRepository landRepo=new LandSizeRepository();
	
	public boolean isAddNewLandSize(LandSizeModel model)
	{
		return landRepo.isAddNewLandSize(model);
	}

}
