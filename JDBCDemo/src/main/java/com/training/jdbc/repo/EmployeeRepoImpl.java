package com.training.jdbc.repo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.training.jdbc.entities.CustomEmployeeRowMapper;
import com.training.jdbc.entities.Employee;

import jakarta.annotation.PostConstruct;
@Repository
public class EmployeeRepoImpl extends JdbcDaoSupport implements EmployeeRepository {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Autowired
	private JdbcTemplate template =  getJdbcTemplate();
	
	GeneratedKeyHolder keyHolder =  new GeneratedKeyHolder();
	
	
    @PostConstruct
    private void init() {
    	
    	setDataSource(dataSource);
    }
	@Override
	public Employee addEmployee(Employee e) {
		String sql = "insert into employees(name,salary) values (?,?)";
		
		//int rowsAffected= template.update(sql,new Object[] {e.getName(),e.getSalary()});
		
		int rowsAffected  = template.update(connection->{
			
			PreparedStatement stat =  connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, e.getName());
			stat.setBigDecimal(2, e.getSalary());
			return stat;
			
		},keyHolder);
		
		int id = keyHolder.getKey().intValue();
		e.setId(id);
		
		
		if(rowsAffected >0) {
			System.out.println(e);
			return e;}
		else
			return null;
		
	}

	@Override
	public List<Employee> addMultipleEmployees(List<Employee> e) {
		
		return null;
	}

	@Override
	public Employee getById(int id) {
		
		
		String sql  = "select * from employees where id = ?";
	return (Employee)template.queryForObject(sql,new Object[] {id},new CustomEmployeeRowMapper());
	
		
	}

	@Override
	public List<Employee> getAll() {
		
		return null;
	}
	
	
	

}
