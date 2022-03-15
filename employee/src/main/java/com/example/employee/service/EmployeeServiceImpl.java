package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.excetion.ResourceNotFoundException;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	public EmployeeRepository empRepository;
	
	@Override
	public List<EmployeeModel> getEmployeeList() {
		return empRepository.findAll();
	}

	@Override
	public EmployeeModel getEmployeebyId(long id) {
		Optional<EmployeeModel> emp = empRepository.findById(id);
		
		if(emp.isPresent()) {
			return emp.get();
		}else {
			return null;
		}
		
	}

	@Override
	public EmployeeModel createEmployee(EmployeeModel employeeModel) {
		return empRepository.save(employeeModel);
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel employeeModel, long id) {
		Optional<EmployeeModel> emp = empRepository.findById(id);
		
		if(emp.isPresent()) {
			EmployeeModel empModel = emp.get();
			empModel.setName(employeeModel.getName());
			empModel.setDepartment(employeeModel.getDepartment());
			empModel.setEmail(employeeModel.getEmail());
			empModel.setSalary(employeeModel.getSalary());
			empModel.setIsPermanent(employeeModel.getIsPermanent());
			return empRepository.save(empModel);
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeModel.getId());
		}
	}

	@Override
	public void deleteEmployee(long id) {
		Optional<EmployeeModel> emp = empRepository.findById(id);
		if(emp.isPresent()) {
			empRepository.delete(emp.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}

}
