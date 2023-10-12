package com.tnsif.jdbc.mvc;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DBUtil {
	static Connection cn;
	static {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/db.properties"));
			Class.forName(prop.getProperty("driver_name"));
			System.out.println("Driver loaded successfully...");
			// establish the connection with database
			cn = DriverManager.getConnection(prop.getProperty("db_url"), prop.getProperty("username"),
					prop.getProperty("password"));
			System.out.println("Connection established successfully....");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getCn()
	{
		return cn;
	}
}
