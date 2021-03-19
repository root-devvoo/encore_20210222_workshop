package com.encore.test;

import java.util.ArrayList;

import com.encore.dao.impl.EmployeeDAOImpl;
import com.encore.vo.Employee;

public class EmployeeDAOTest {
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		/////////////////////////////////////////////////
//		EmployeeDAOImpl.getInstance().insertEmp(new Employee(444, "Ronnie", 4000.0, "LA"));
//		EmployeeDAOImpl.getInstance().removeEmp(222);
//		EmployeeDAOImpl.getInstance().updateEmp(new Employee(444, "Mac", 5500.1, "Nevada"));
		ArrayList<Employee> returnList = EmployeeDAOImpl.getInstance().selectAll();
		for(Employee e : returnList) System.out.println(e);
	}
}
