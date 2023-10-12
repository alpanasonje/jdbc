//Program to demonstrate JDBC CRUD Operation
package com.tnsif.jdbc.mvc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Executor {

	public static void main(String[] args) {

		StudentServiceImpl service;
		List<Student> studList;
		int n;
		Student st;
		try {
			service = new StudentServiceImpl();
			
			
			/*
			 * st=new Student(1,"Nehal",87); service.addStudent(new Student(2,"Nitin",89));
			 * service.addStudent(new Student(6,"Pratik",65)); service.addStudent(new
			 * Student(3,"Bharat",87)); service.addStudent(new Student(4,"Manoj",73));
			 */
			 			
				
			studList = service.getAllStudents();
			System.out.println(studList.isEmpty()?"No students available":"---All Students---\n"+studList);

			System.out.println("----------------------------------");
			studList = service.getStudentsByPer(75);
			System.out.println(studList.isEmpty()?"No students available":"-----Students with 75 and more percentage----\n"+studList);
			
			System.out.println("----------------------------------");
			studList = service.getStudentsNameStartsWith("n%");
			System.out.println(studList.isEmpty()?"No students available":"----Students name starts with N-----\n"+studList);
			
			System.out.println("----------------------------------");
			//n=service.deleteAllStudents();
			//System.out.println(n>0?n+" record(s) deleted...":"No students available");
			
			//n=service.deleteByRollNo(6);
			//System.out.println(n>0?n+" record(s) deleted...":"No students available");
			
			n=service.updateStudentPer(10);
			System.out.println(n>0?n+" record(s) updated...":"No students available");
			
			studList = service.getAllStudents();
			System.out.println(studList.isEmpty()?"No students available":"---All Students---\n"+studList);
			
			n=service.updateStudentPerByRollNo(6, 50);
			System.out.println(n>0?n+" record(s) updated...":"No students available");
			
			studList = service.getAllStudents();
			System.out.println(studList.isEmpty()?"No students available":"---All Students---\n"+studList);
			

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
