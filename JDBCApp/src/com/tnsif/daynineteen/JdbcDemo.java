//Program to demonstrate simple JDBC CRUD operation
package com.tnsif.daynineteen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		try {
			//Load the JDBC driver for Mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully...");
			//establish the connection with database
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "alpana@123");
			System.out.println("Connection established successfully....");
			
			//Statement - used for static queries
			Statement st=cn.createStatement();
			//Retrieving data from student table
			ResultSet rs=st.executeQuery("SELECT * FROM student");
			while(rs.next())
			{
				//fetching single record
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
			}
			rs.close();
			
			//Inserting data into student table
			int n=st.executeUpdate("INSERT INTO student VALUES(7,'Pratik',82)");
			if (n==1)
				System.out.println("Record inserted Successfully....");
			else
				System.out.println("Unable to insert record");
			
			//delele students whose name starts with p
			n=st.executeUpdate("DELETE FROM student WHERE sname LIKE 'p%'");
			if (n>=1)
				System.out.println(n+" Record(s) Deleted Successfully....");
			else
				System.out.println("No such record found");
			
			//update student percentage increased by 5
			n=st.executeUpdate("UPDATE student SET per=per+5 WHERE per<96");
			if (n>=1)
				System.out.println(n+" Record(s) Updated Successfully....");
			else
				System.out.println("No such record found");
			
			//Terminate the connection
			cn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		}

	}

}
