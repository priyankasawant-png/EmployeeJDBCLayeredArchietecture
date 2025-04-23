package com.capgemini.training.ui;

import java.sql.SQLException;
import java.util.Date;

import com.capgemini.training.businessbean.EmployeeBean;
import com.capgemini.training.service.EmployeeService;
import com.capgemini.training.service.EmployeeServiceImpl;

public class UITester {
	public static void main(String[] args) {
		//insertEmployee();
		//readEmployee();
		//updateEmployee();
		deleteEmployee();
	}

	public static void readEmployee() {
		try {
			EmployeeService employeeService = new EmployeeServiceImpl();
			employeeService.readEmployee();
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateEmployee() {
		try {
			EmployeeService employeeService = new EmployeeServiceImpl();
			EmployeeBean bean = new EmployeeBean();
			bean.setEmployeeId(1002);
			bean.setSalary(500000.0);
			employeeService.updateEmployee(bean);
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteEmployee() {
		try {
			EmployeeService employeeService = new EmployeeServiceImpl();
			EmployeeBean bean = new EmployeeBean();
			bean.setEmployeeId(1004);
			employeeService.deleteEmployee(bean);
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}	
	}

	public static void insertEmployee() {
		// TODO Auto-generated method stub
		try {
			EmployeeService employeeService = new EmployeeServiceImpl();
			EmployeeBean bean = new EmployeeBean();
			bean.setEmployeeId(1004);
			bean.setEmployeeName("Rupini");
			bean.setRole("Analyst");
			bean.setSalary(30000.0);
			bean.setInsertTime(new Date());
			employeeService.insertEmployee(bean);
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
