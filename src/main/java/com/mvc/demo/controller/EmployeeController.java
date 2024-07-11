package com.mvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.demo.entity.Employee;
import com.mvc.demo.repository.EmployeeRepository;
import com.mvc.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add";
	}

	@PostMapping("/add")
	public String addEmployeeToDB(@ModelAttribute("employee") Employee employee) {

		employeeService.saveProduct(employee);
		return "redirect:/view";
	}

	@GetMapping("/view")
	public String viewEmployee(Model model) {

		List<Employee> employeeList = employeeService.getAllProductList();

		model.addAttribute("employees", employeeList);

		return "view";
	}

	@GetMapping("/update/{id}")
	public String updateEmployee(Model model, @PathVariable("id") Integer id) {

		Employee employee = employeeRepository.findById(id).get();

		model.addAttribute("employee", employee);

		return "update";
	}

	@PostMapping("/update")
	public String updateEmployeeById(@ModelAttribute("employee") Employee employee) {

		Employee emp = employeeService.getEmployeeById(employee.getId());
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setMobile(employee.getMobile());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());

		employeeRepository.save(emp);

		return "redirect:/view";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {

		employeeRepository.deleteById(id);

		return "redirect:/view";
	}

}
