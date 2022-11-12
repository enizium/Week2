package com.guideme.crud.dao;

import java.util.List;

import com.guideme.crud.dto.Employee;

public interface EmployeeDAO {
	public List<Employee> getlistOfEmployees();
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(String userName);
	public Employee fineEmployee(String userName);
}
