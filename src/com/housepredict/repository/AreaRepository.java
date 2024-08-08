package com.housepredict.repository;

import java.util.*;
import com.housepredict.config.DBConfig;
import com.housepredict.model.AreaMasterModel;

public class AreaRepository extends DBConfig {
	List<AreaMasterModel> list;
//	List<String> aList=new ArrayList<String>();
	

	public boolean isAddNewArea(AreaMasterModel model) {

		try {
			cstmt = conn.prepareCall("{call savearea(?,?,?)}");
			cstmt.setString(1, model.getAreaname());
			cstmt.setInt(2, model.getCityId());
			cstmt.setString(3, model.getPincode());
			boolean b = cstmt.execute();
			return !b;

		} catch (Exception e) {
			System.out.println("error is there" + e);
			return false;
			// TODO: handle exception
		}
	}

	public List<AreaMasterModel> getCityByAreaName() {
		try {
			list = new ArrayList<AreaMasterModel>();
			stmt = conn.prepareStatement(
					"select c.name as 'city name',a.name as 'area name',acj.pincode from citymaster c inner join cityareajoin acj on c.cityid=acj.cityid inner join areamaster a on acj.aid=a.aid");
			rs = stmt.executeQuery();
			while (rs.next()) {
				AreaMasterModel model = new AreaMasterModel();
				model.setName(rs.getString(1));
				model.setAreaname(rs.getString(2));
				model.setPincode(rs.getString(3));
				list.add(model);
			}
			return list.size() > 0 ? list : null;

		} catch (Exception e) {
			System.out.println("Error is " + e);
			// TODO: handle exception
		}
		return null;
	}

	public int getAreaIdByName(String AreaName) {
		try {
			
			stmt = conn.prepareStatement("select aid from areamaster where name=?");
            stmt.setString(1, AreaName);
            
            rs=stmt.executeQuery();
			if (rs.next()) 
			{
				return rs.getInt(1);
			}
			else
				return 0;
		    } catch (Exception e) {
			System.out.println(e);
			return 1;
		
		    }
	}

	public List<String> areaList(int cityId) {
		try {
			List<String> l = new ArrayList<String>();
			stmt = conn.prepareStatement(
					"select ar.name from areamaster ar inner join cityareajoin acj on ar.aid=acj.aid inner join citymaster cm on cm.cityid=acj.cityid where cm.cityid=?");
			stmt.setInt(1, cityId);
			rs=stmt.executeQuery();
			while (rs.next())
			{
				list=new ArrayList<AreaMasterModel>();
//               
				l.add(rs.getString(1));
//				System.out.println(rs.getString(1));

			}
			return l.size() > 0 ? l : null;

		} catch (Exception e) {
			System.out.println("Error in " + e);
			return null;
			// TODO: handle exception
		}
		

	}
}


