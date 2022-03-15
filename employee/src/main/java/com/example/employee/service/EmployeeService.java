package com.example.employee.service;

import java.util.List;

import com.example.employee.model.EmployeeModel;

public interface EmployeeService {

	List<EmployeeModel> getEmployeeList();
	
	public EmployeeModel getEmployeebyId(long id);
	
	public EmployeeModel createEmployee(EmployeeModel employeeModel);
	
	public EmployeeModel updateEmployee(EmployeeModel employeeModel,long id);
	
	public void deleteEmployee(long id);
	
}
