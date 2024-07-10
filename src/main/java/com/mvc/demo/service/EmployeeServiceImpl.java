package com.mvc.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.demo.entity.Employee;
import com.mvc.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveProduct(Employee product) {
		logger.debug("saveProduct() execution started");
		 employeeRepository.save(product);
	}

	@Override
	public List<Employee> getAllProductList() {
		
		logger.debug("getAllProductList() execution started");

		List<Employee> list = employeeRepository.findAll();
		
		logger.debug("getAllProductList() execution stopped");
		return list;
	}
}
