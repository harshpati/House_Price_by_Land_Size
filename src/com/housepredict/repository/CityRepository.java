package com.housepredict.repository;
import java.sql.PreparedStatement;
import java.util.*;
import com.housepredict.config.DBConfig;
import com.housepredict.model.CityMasterModel;

import com.housepredict.config.DBConfig;

public class CityRepository extends DBConfig
{
public boolean isAddCity(CityMasterModel model)
{
	try 
	{
		stmt=conn.prepareStatement("insert into citymaster values('0',?)");
		stmt.setString(1, model.getName());
		int value=stmt.executeUpdate();
		return value>0?true:false;
	} 
	catch (Exception e) 
	{
		System.out.println("Error is "+e);
		return false;
	}
	
}
public List<CityMasterModel> getAllCities()
{
	try 
	{
	List list=new ArrayList<CityMasterModel>();
		stmt=conn.prepareStatement("select *from citymaster");
		rs=stmt.executeQuery();
		while(rs.next())
		{
			CityMasterModel model=new CityMasterModel();
			model.setCityId(rs.getInt(1));
			model.setName(rs.getString(2));
			list.add(model);
		}
		return list.size()>0?list:null;
	}
	catch (Exception e) 
	{
		System.out.println("Error is "+e);
		return null;
		// TODO: handle exception
	}
	
}

public int getCityIdByName(String cityName)
{
	try 
	{
		stmt=conn.prepareStatement("select *from citymaster where name=?");
		stmt.setString(1,cityName);
		rs=stmt.executeQuery();
		if (rs.next()) 
		{
			return rs.getInt(1);
		}
		else
		{
			return 0;
		}
	} 
	catch (Exception e) 
	{
		return -1;
	}
	
}


}
