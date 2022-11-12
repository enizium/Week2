package com.guideme.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.guideme.crud.dto.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	NamedParameterJdbcTemplate template;

	@Autowired
	public void setTemplate(NamedParameterJdbcTemplate template) throws DataAccessException {
		this.template = template;
	}

	private SqlParameterSource getSqlParamsByModel(Employee emp) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (emp != null) {
			parameterSource.addValue("id", emp.getEmployeeid());
			parameterSource.addValue("firstname", emp.getFirstname());
			parameterSource.addValue("lastname", emp.getLastname());
			parameterSource.addValue("email", emp.getEmail());
			parameterSource.addValue("phonenumber", emp.getPhoneNumber());
			parameterSource.addValue("post", emp.getPost());

		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setEmail(rs.getString("email"));
			emp.setFirstname(rs.getString("firstname"));
			emp.setLastname(rs.getString("lastname"));
			emp.setEmployeeid(rs.getInt("employeeid"));
			emp.setPhoneNumber(rs.getString("phonenumber"));
			emp.setPost(rs.getString("post"));
			return emp;
		}
	}

	public List<Employee> getlistOfEmployees() {
		System.out.println("Get Employee List Called");
		String query = "SELECT employeeid, firstname, lastname, email, post, phonenumber FROM employee";
		List<Employee> list = template.query(query, getSqlParamsByModel(null), new UserMapper());
		return list;
	}

	public void addEmployee(Employee e) {
		String query = "INSERT INTO employee(firstname, lastname, email, phonenumber, post) VALUES (:firstname, :lastname, :email)";
		template.update(query, getSqlParamsByModel(e));
	}

	public void updateEmployee(Employee e) {
		String query = "UPDATE employee SET firstname = :firstname, lastname = :lastname , email = :email, post = :post, phonenumber = :phonenumber WHERE firstname = :firstname";
		template.update(query, getSqlParamsByModel(e));
	}

	public void deleteEmployee(String firstname) {
		String query = "DELETE FROM employee WHERE firstname = :firstname";
		template.update(query, getSqlParamsByModel(new Employee(firstname)));
	}

	public Employee fineEmployee(String firstname) {
		String query = "SELECT * FROM employee WHERE firstname = :firstname";
		return (Employee)template.queryForObject(query, getSqlParamsByModel(new Employee(firstname)), new UserMapper());
	}

}
