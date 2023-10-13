//Program to define Employee Service interface for CRUD operation
package com.tnsif.daytwenty.service;

import java.sql.SQLException;
import java.util.List;

import com.tnsif.daytwenty.entity.Employee;

public interface IEmployeeService {
	int addEmployee(Employee emp) throws SQLException;

	int deleteEmployeeByEmpNo(int empNo) throws SQLException;

	int updateEmployeeByEmpNo(int empNo, Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

}
