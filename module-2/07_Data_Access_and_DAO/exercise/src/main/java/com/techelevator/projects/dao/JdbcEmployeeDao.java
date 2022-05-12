package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select employee_id, department_id, first_name, last_name, birth_date, hire_date from employee;";
		List<Employee> employees = new ArrayList<>();

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeesByName = new ArrayList<>();

		String firstName = "";
		String lastName = "";
		String where = "";
		String and = "";

		SqlRowSet results;

		if ((firstNameSearch != null) && (lastNameSearch != null)) {
			where = " WHERE ";
			firstName = " first_name ILIKE ? ";
			and = " AND ";
			lastName = " last_name ILIKE ? ";
		}
		if ((firstNameSearch != null) && (lastNameSearch == null)) {
			where = " WHERE ";
			firstName = " first_name ILIKE ? ";
		}
		if ((firstNameSearch == null) && (lastNameSearch != null)) {
			where = " WHERE ";
			lastName = " last_name ILIKE ? ";
		}

		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee " + where + firstName + and + lastName + ";";

		if ((firstNameSearch != null) && (lastNameSearch != null)) {
			results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		}

		else if ((firstNameSearch != null) && (lastNameSearch == null)) {
			results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%");
		}
		else if ((firstNameSearch == null) && (lastNameSearch != null)) {
			results = jdbcTemplate.queryForRowSet(sql, "%" + lastNameSearch + "%");
		} else {
			results = jdbcTemplate.queryForRowSet(sql);
		}
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employeesByName.add(employee);
		}
		return employeesByName;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeesByProject = new ArrayList<>();

		String sql = "select employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " + " FROM employee " +
				" JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				" WHERE project_id = ?; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employeesByProject.add(employee);
		}
		return employeesByProject;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) " + " VALUES(?, ?); ";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemove = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?; ";
		jdbcTemplate.update(sqlRemove, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeesWithoutProjects = new ArrayList<>();

		String sql = "select employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " + " FROM employee " +
				" LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				" WHERE project_id IS NULL; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employeesWithoutProjects.add(employee);
		}
		return employeesWithoutProjects;
	}

	private Employee mapRowToEmployee(SqlRowSet results){
		Employee employee = new Employee();
		employee.setId(results.getLong("employee_id"));
		employee.setDepartmentId(results.getLong("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		employee.setBirthDate(results.getDate("birth_date").toLocalDate());
		employee.setHireDate(results.getDate("hire_date").toLocalDate());

		return employee;
	}
}
