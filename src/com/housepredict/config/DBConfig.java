package com.housepredict.config;
import java.io.File;
import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DBConfig
{
protected Connection conn;
protected PreparedStatement stmt;
protected ResultSet rs;   
protected CallableStatement cstmt;
public DBConfig()
   {	
	try 
	{
		
//		System.out.println(mainPath);
		//String driverclassname=p.getProperty("db.driverClass");
		String username=PathHelper.p.getProperty("db.username");
		String password=PathHelper.p.getProperty("db.password");
		String url=PathHelper.p.getProperty("db.url");
		
		
		Class.forName(PathHelper.p.getProperty("db.driverClass"));
		conn=DriverManager.getConnection(url,username,password);
		System.out.println("database connected");
	} 
	catch (Exception e) 
	{
		System.out.println("error is "+e);
	}
   }
public static void main(String[] args) {
	new DBConfig();
}
}
