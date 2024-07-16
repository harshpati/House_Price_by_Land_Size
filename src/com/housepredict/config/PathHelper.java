package com.housepredict.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PathHelper 
{
  static Properties p=new Properties();
	
	static
	{
		File f=new File(".");
		String filePath=f.getAbsolutePath();
		String mainPath=filePath.substring(0,filePath.length()-1)+"src\\com\\housepredict\\config\\db.properties";
		System.out.println(mainPath);
		FileInputStream fin;
		
		try {
			fin=new FileInputStream(mainPath);
			p.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
