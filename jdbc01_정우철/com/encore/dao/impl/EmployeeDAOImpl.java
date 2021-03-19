package com.encore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.dao.EmployeeDAO;
import com.encore.vo.Employee;

import config.ServerInfo;



public class EmployeeDAOImpl implements EmployeeDAO{
	private static EmployeeDAOImpl dao = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("Driver Loading...");
		}catch (ClassNotFoundException e) {
		}
	}
	public static EmployeeDAOImpl getInstance() {
		return dao;
	}
	
	//공통적인 부분 로직
	@Override
	public Connection getConnect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("DB 서버 연결..");
		
		}catch (SQLException e) {	
	}
	return conn;	
}
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {
		}
	}
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if(rs!=null) rs.close();
			closeAll(ps, conn);
		}catch (SQLException e) {
		}
	}
	@Override
	public void insertEmp(Employee emp) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "insert into employee values(?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			System.out.println("PrepareStatement 객체 생성...");
			
			ps.setInt(1, emp.getNum());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getAddress());
			
			System.out.println(ps.executeUpdate()+"명 추가되었습니다.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void removeEmp(int num) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "delete from employee where num=?";
		try {
			ps = conn.prepareStatement(query);
			System.out.println("PrepareStatement 객체 생성...");
			
			ps.setInt(1, num);
			System.out.println(ps.executeUpdate()+"명 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateEmp(Employee emp) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		
		String query = "update employee set name = ?, salary = ?, address = ? Where num = ?";
		try {
			ps = conn.prepareStatement(query);
			System.out.println("PrepareStatement 객체 생성...");
			
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setString(3, emp.getAddress());
			ps.setInt(4, emp.getNum());
			
			System.out.println(ps.executeUpdate()+"명 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<Employee> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		conn = getConnect();
		
		String query = "select num, name, salary, address from employee";
		try {
			ps = conn.prepareStatement(query);
			System.out.println("PrepareStatement 객체 생성...");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("num"),
									  rs.getString("name"),
									  rs.getDouble("salary"),
									  rs.getString("address")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeAll(rs, ps, conn);
		}
		return list;
	}
}
