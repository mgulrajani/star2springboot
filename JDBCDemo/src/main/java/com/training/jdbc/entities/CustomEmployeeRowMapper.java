package com.training.jdbc.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomEmployeeRowMapper  implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Employee e =  new Employee();
			e.setId(rs.getInt("id"));

			e.setName(rs.getString("name"));
			e.setSalary(rs.getBigDecimal("salary"));
			return e;
			
		}

		
		


}
