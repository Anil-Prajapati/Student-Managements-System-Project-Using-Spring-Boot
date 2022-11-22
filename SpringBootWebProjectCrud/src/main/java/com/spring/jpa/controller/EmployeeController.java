package com.spring.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.jpa.entitry.Employee;
import com.spring.jpa.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/")
	public String viewEmployee(Model model) {
		model.addAttribute("listEmployees", empService.getAll());
		return "index";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("Employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {
		Employee employee = empService.getEmployeeById(id);
		model.addAttribute("employee", employee);

		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Integer id) {
		empService.deleteEmployee(id);

		return "redirect:/";
	}

	// controller concept of the pageable
//	@GetMapping("/page/{pageNo}")
//	public String viewPagination(@PathVariable(value = "pageNo") int pageNo, Model m) {
//		int pageSize = 2; // How many records on per page
//		Page<Employee> page = empService.findByPagination(pageNo, pageSize);
//		List<Employee> list = page.getContent();
//		m.addAttribute("currentPage", pageNo);
//		m.addAttribute("totalPages", page.getTotalPages());
//		m.addAttribute("totalRecords", page.getTotalElements());
//		m.addAttribute("list", list);
//		
//		return "index";
//	}

}
