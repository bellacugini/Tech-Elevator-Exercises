package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long id) {
		Department department = null;
		String sql = "SELECT department.name, department.department_id FROM department " +
				" WHERE department.department_id = ?; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			department = mapRowToDepartment(results);
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {

		String sql = "select department_id, name from department;";
		List<Department> departments = new ArrayList<>();

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){

			Department department = mapRowToDepartment(results);
			departments.add(department);
		}

		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department SET name = ? WHERE department_id=?";
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());
	}

	private Department mapRowToDepartment(SqlRowSet results){
		Department department = new Department();
		department.setId(results.getLong("department_id"));
		department.setName(results.getString("name"));

		return department;
	}

}
