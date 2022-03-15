package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.EmployeeModel;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeModel>> getAllEmployees(){
		return ResponseEntity.ok().body(employeeService.getEmployeeList());
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable long id){
		return ResponseEntity.ok().body(employeeService.getEmployeebyId(id));
	}
	
	@PostMapping("/employee/create")
	public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel){
		return ResponseEntity.ok().body(employeeService.createEmployee(employeeModel));
	}
	
	@PutMapping("/employee/update/{id}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable long id,@RequestBody EmployeeModel employeeModel){
		return ResponseEntity.ok().body(employeeService.updateEmployee(employeeModel, id));
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}
}
