package com.encore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.vo.Employee;

public interface EmployeeDAO {
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn);
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn);
	void insertEmp(Employee emp);
	void removeEmp(int num);
	void updateEmp(Employee emp);
	ArrayList<Employee> selectAll();
	
}
