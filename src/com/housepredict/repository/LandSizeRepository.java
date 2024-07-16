package com.housepredict.repository;

import com.housepredict.config.DBConfig;
import com.housepredict.model.LandSizeModel;

public class LandSizeRepository extends DBConfig
{
	public boolean isAddNewLandSize(LandSizeModel model)
	{
		try 
		{
			stmt=conn.prepareStatement("insert into landsizemaster values('0',?)");
		    stmt.setInt(1, model.getSqFeet());		
		    int val=stmt.executeUpdate();
		    return val>0?true:false;
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		
		}
		return false;
	}
	

}
