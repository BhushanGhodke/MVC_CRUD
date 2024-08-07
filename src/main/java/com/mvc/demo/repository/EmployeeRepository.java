package com.mvc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
