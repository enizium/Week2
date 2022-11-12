package com.guideme.crud.service;

import java.util.List;

import com.guideme.crud.dto.Employee;

public interface EmployeeService {
	public List<Employee> getlistOfEmployees();

	public void addEmployee(Employee e);

	public void updateEmployee(Employee e);

	public void deleteEmployee(String userName);

	public Employee findEmployee(String userName);
}
