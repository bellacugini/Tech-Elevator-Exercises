package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
				"FROM project WHERE project_id = ?; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		if (results.next()) {
			project = mapRowToProject(results);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "select project_id, name, from_date, to_date from project;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){

			Project project = mapRowToProject(results);
			projects.add(project);
		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (project_id, name, from_date, to_date) " + " VALUES(?, ?, ?, ?) RETURNING project_id;";

		Long newId = jdbcTemplate.queryForObject(sql, Long.class, newProject.getId(),
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		return getProject(newId);
	}

	@Override
	public void deleteProject(Long projectId) {
		String sqlDeleteFromProjectEmployee = "DELETE FROM project_employee WHERE project_id = ?; ";
		jdbcTemplate.update(sqlDeleteFromProjectEmployee, projectId);
		String sqlDeleteFromProject = "DELETE FROM project WHERE project_id = ?; ";
		jdbcTemplate.update(sqlDeleteFromProject, projectId);
	}

	private Project mapRowToProject(SqlRowSet results){
		Project project = new Project();
		project.setId(results.getLong("project_id"));
		project.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
//		project.setFromDate(results.getDate("from_date").toLocalDate());
//		project.setToDate(results.getDate("to_date").toLocalDate());

		return project;
	}
	

}
