package com.capgemini.training.service;

import java.sql.SQLException;

import com.capgemini.training.businessbean.EmployeeBean;

public interface EmployeeService {
	
	public int insertEmployee(EmployeeBean bean) throws
	ClassNotFoundException, SQLException;
	
	public void readEmployee() throws ClassNotFoundException,SQLException;
	
	public void updateEmployee(EmployeeBean bean) throws 
	SQLException,ClassNotFoundException;
	
	public void deleteEmployee(EmployeeBean bean) throws
	ClassNotFoundException,SQLException;

}
