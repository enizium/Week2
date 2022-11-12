package com.guideme.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guideme.crud.dao.EmployeeDAO;
import com.guideme.crud.dto.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDao;

	@Autowired
	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getlistOfEmployees() {
		return employeeDao.getlistOfEmployees();
	}

	public void addEmployee(Employee e) {
		employeeDao.addEmployee(e);
	}

	public void updateEmployee(Employee e) {
		employeeDao.updateEmployee(e);
	}

	public void deleteEmployee(String userName) {
		employeeDao.deleteEmployee(userName);
	}

	public Employee findEmployee(String userName) {
		return employeeDao.fineEmployee(userName);
	}

}
