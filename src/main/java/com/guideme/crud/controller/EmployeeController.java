package com.guideme.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guideme.crud.dto.Employee;
import com.guideme.crud.service.EmployeeService;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listEmployee() {
		ModelAndView mvc = new ModelAndView("pages/empPage");
		List<Employee> list = empService.getlistOfEmployees();
		mvc.addObject("listEmployees", list);
		return mvc;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("pages/employee_form");
		Employee emp = new Employee();
		model.addObject("employeeForm", emp);
		return model;
	}

	@RequestMapping(value = "/update/{username}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("pages/employee_form");
		Employee emp = empService.findEmployee(username);
		model.addObject("employeeForm", emp);
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("employeeForm") Employee employee) {
		if (employee != null && employee.getEmployeeid() == 0) {
			empService.addEmployee(employee);
		} else {
			empService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/employees/list");
	}

	@RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("username") String username) {
		empService.deleteEmployee(username);
		return new ModelAndView("redirect:/employees/list");
	}
}
