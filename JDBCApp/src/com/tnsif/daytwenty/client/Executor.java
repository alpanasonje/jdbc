package com.tnsif.daytwenty.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.tnsif.daytwenty.entity.Employee;
import com.tnsif.daytwenty.service.EmployeeServiceImpl;

public class Executor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch,n;
		int empno;
		String empname;
		float salary;
		Employee emp;
		List<Employee> empList;
		EmployeeServiceImpl service=new EmployeeServiceImpl();
		try {
		do
		{
			System.out.println("-----------Employee-----------");
			System.out.println("1. Add Employee");
			System.out.println("2. Delete Employee");
			System.out.println("3. Upodate Employee");
			System.out.println("4. Display All Employees");
			System.out.println("5. Close");
			System.out.println("Enter your choice(1..5) : ");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter Employee Details : ");
				System.out.println("Employee No. : ");
				empno=sc.nextInt();
				System.out.println("Employee Name : ");
				empname=sc.next();
				System.out.println("Employee Salary : ");
				salary=sc.nextFloat();
				emp=new Employee(empno, empname, salary);
				n=service.addEmployee(emp);
				/*
				 * if (n>0) System.out.println(n+" employee(s) added.."); else
				 * System.out.println("Insertion failed...");
				 */
				System.out.println(n>0?n+" employee(s) added..":"Insertion failed...");
				
				break;
			case 2:
				System.out.println("Employee No to delete a record : ");
				empno=sc.nextInt();
				n=service.deleteEmployeeByEmpNo(empno);
				System.out.println(n>0?n+" employee(s) deleted..":"Deletion failed...");
				break;
			case 3:
				System.out.println("Employee No to modify a record : ");
				empno=sc.nextInt();
				System.out.println("Enter updated employee name : ");
				empname=sc.next();
				System.out.println("Enter updated salary : ");
				salary=sc.nextFloat();
				emp=new Employee(empno, empname, salary);
				n=service.updateEmployeeByEmpNo(empno,emp);
				System.out.println(n>0?n+" employee(s) updated..":"Modification failed...");
				
				break;
			case 4:
				empList=service.getAllEmployees();
				System.out.println(empList);
				break;
			case 5:
				System.out.println("Thank you for using application");
				break;
				default:System.out.println("Invalid choice..");
			}
		}while(ch<5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
