package com.housepredict.clientapplication;

//all import packages here
import java.util.*;

// all model classes
import com.housepredict.model.CityMasterModel;
import com.housepredict.model.LandSizeModel;
import com.housepredict.model.AreaMasterModel;
import com.housepredict.service.AreaService;
//all service classes
import com.housepredict.service.CityServices;
import com.housepredict.service.LandSizeService;

public class precitionClientApplication {

	public static void main(String[] args) {
		// services objects are here
		CityServices cs = new CityServices();
		AreaService aservice = new AreaService();
        LandSizeService lservice=new LandSizeService();
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("1:Add New City");
			System.out.println("2:View New City");
			System.out.println("3:Add New Area");
			System.out.println("4:get Area By CityName");
			System.out.println("5:Add New Land Area");
			System.out.println("6:Enter property detail");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				input.nextLine();
				System.out.println("Enter cityName");
				String cityName = input.nextLine();

				CityMasterModel model = new CityMasterModel();
				model.setName(cityName);
				boolean b = cs.isAddCity(model);
				if (b) {
					System.out.println("City Added Succesfully");
				} else {
					System.out.println("Some Problem is There");
				}
				break;

			case 2:
				List<CityMasterModel> list = cs.getAllCities();
				for (CityMasterModel c : list) {
					System.out.println(c.getCityId() + "\t" + c.getName());
				}
				break;

			case 3:
				input.nextLine();
				System.out.println("Enter city name");
				cityName = input.nextLine();
				int result = cs.getCityIdByName(cityName);
				// System.out.println("ID is "+result);
				if (result == 0) 
				{

					System.out.println("City is not present \n do you want to add this city");
					String confirm = input.nextLine();
					if (confirm.equals("yes")) {

						model = new CityMasterModel();
						model.setName(cityName);
						b = cs.isAddCity(model);
						if (b) {
							System.out.println("City Added Succesfully");
						} else {
							System.out.println("Some Problem is There");
						}
					}
				} else if (result != 0) {
					// System.out.println("City is Present");

					System.out.println("Enter Area Name");
					String areaName = input.nextLine();
					System.out.println("Enter Pincode of Area");
					String pincode = input.nextLine();

					AreaMasterModel areaModel = new AreaMasterModel();
					areaModel.setAreaname(areaName);
					areaModel.setCityId(result);
					areaModel.setPincode(pincode);

					b = aservice.isAddNewArea(areaModel);
					if (b) {
						System.out.println("Area Added");
					} else {
						System.out.println("Area Not Added");
					}

				} 
				else {
					System.out.println("There Are Some Exception");
				}
				break;
			case 4:
				System.out.println("Show All Area with city name");
				List<AreaMasterModel> areaList=aservice.getCityByAreaName();
				for (AreaMasterModel A : areaList) 
				{
					System.out.println(A.getName()+"\t"+A.getAreaname()+"\t"+A.getPincode());
					
				}
				break;
			case 5:
				System.out.println("Enter New land area size");
				int landSize=input.nextInt();
				LandSizeModel landModel=new LandSizeModel();
				landModel.setSqFeet(landSize);
				 b=lservice.isAddNewLandSize(landModel);
				 if (b) 
				{
					 System.out.println("Land Added Sucessfully");
					
				}
				 else
				 {
					 System.out.println("Land Not Added");
				 }
				 break;
				 
			case 6:
				input.nextLine();
				System.out.println("enter city name");
				cityName = input.nextLine();
				result = cs.getCityIdByName(cityName);
//				System.out.println(result);
				List<String> AreaName=aservice.areaList(result);
				System.out.println("input area from given list");
				for(String aname:AreaName)
				{
					System.out.println(aname);
				}
				System.out.println("Enter Area Name");
				String AreaName1 = input.nextLine();
				int areaId=aservice.getAreaIdByName(AreaName1);
				System.out.println("AreaID is "+areaId);
				
				
				
				break;
			default:
				System.out.println(" Wrong choice");

			}

		} while (true);
	}
}
