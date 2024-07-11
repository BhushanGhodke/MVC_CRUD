package com.mvc.demo.service;

import java.util.List;

import com.mvc.demo.entity.Employee;

public interface EmployeeService  {

	public void saveProduct(Employee product);

	public List<Employee> getAllProductList();
	
	public Employee getEmployeeById(Integer id);
}
