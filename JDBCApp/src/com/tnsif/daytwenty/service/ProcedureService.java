package com.tnsif.daytwenty.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;

import com.tnsif.daytwenty.dao.DBUtil;

public class ProcedureService {
	Statement st;
	PreparedStatement pst;
	CallableStatement cst;
	Connection cn;
	
	public ProcedureService() throws SQLException
	{
		cn=DBUtil.getCn();
		st=cn.createStatement();
	}
	
	public int updateSalary() throws SQLException
	{
		int n=0;
		if (st.execute("{call updateSalary()}")==false)
		{
			n=st.getUpdateCount();
		}
		return n;
	}
	
	public int deleteStudent(float per) throws SQLException
	{
		int n=0;
		//if (st.execute("{call deleteStudent("+per+")}")==false)
		pst=cn.prepareStatement("{call deleteStudent(?)}");
		pst.setFloat(1, per);
		if (pst.execute()==false)
		{
			n=pst.getUpdateCount();
		}
		return n;
	}
	
	public String getStudentName(int rollNo) throws SQLException
	{
		String name=null;
		cst=cn.prepareCall("{?= call getStudent(?)}");
		cst.setInt(2, rollNo);
		cst.registerOutParameter(1, Types.VARCHAR);
		cst.execute();
		name=cst.getString(1);			
		
		return name;
	}

}
