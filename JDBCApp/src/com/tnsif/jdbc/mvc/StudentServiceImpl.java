//Program to implement Student Service Interface
package com.tnsif.jdbc.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
	static Connection cn;
	Statement st;
	PreparedStatement pst;

	public StudentServiceImpl() throws SQLException {

		cn = DBUtil.getCn();
		st = cn.createStatement();

	}

	@Override
	public void addStudent(Student student) throws SQLException {
		// String sql="INSERT INTO student
		// VALUES("+student.getRollNo()+",'"+student.getSname()+"',"+student.getPer()+")";
		// int n=st.executeUpdate(sql);
		pst = cn.prepareStatement("INSERT INTO student VALUES(?,?,?)");
		pst.setInt(1, student.getRollNo());
		pst.setString(2, student.getSname());
		pst.setFloat(3, student.getPer());
		int n = pst.executeUpdate();
		System.out.println("Student added...");
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		List<Student> studList = new ArrayList<Student>();
		ResultSet rs = st.executeQuery("SELECT * FROM student");
		while (rs.next()) {
			Student st = new Student(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			studList.add(st);
		}
		rs.close();
		return studList;
	}

	@Override
	public List<Student> getStudentsByPer(float value) throws SQLException {
		List<Student> studList = new ArrayList<Student>();
		// ResultSet rs=st.executeQuery("SELECT * FROM student WHERE per>="+value);
		pst = cn.prepareStatement("SELECT * FROM student WHERE per>=?");
		pst.setFloat(1, value);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Student st = new Student(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			studList.add(st);
		}
		pst.close();
		rs.close();
		return studList;
	}

	@Override
	public List<Student> getStudentsNameStartsWith(String str) throws SQLException {
		List<Student> studList = new ArrayList<Student>();
		pst = cn.prepareStatement("SELECT * FROM student WHERE sname LIKE ?");
		pst.setString(1, str);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Student st = new Student(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			studList.add(st);
		}
		pst.close();
		rs.close();
		return studList;
	
	}

	@Override
	public int deleteAllStudents() throws SQLException {
		int n=st.executeUpdate("DELETE FROM student");
		return n;
	}

	@Override
	public int deleteByRollNo(int value) throws SQLException {
		int n=st.executeUpdate("DELETE FROM student where rollno ="+value);
		return n;
	}

	@Override
	public int updateStudentPer(float value) throws SQLException {
		pst=cn.prepareStatement("UPDATE student SET per=per+? WHERE per<=?");
		pst.setFloat(1,value);
		pst.setFloat(2,100-value);
		int n=pst.executeUpdate();
		return n;
	}

	@Override
	public int updateStudentPerByRollNo(int rvalue, float pvalue) throws SQLException {
		pst=cn.prepareStatement("UPDATE student SET per=? WHERE rollno=?");
		pst.setFloat(1,pvalue);
		pst.setInt(2,rvalue);
		int n=pst.executeUpdate();
		return n;
	}

	@Override
	protected void finalize() {
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
