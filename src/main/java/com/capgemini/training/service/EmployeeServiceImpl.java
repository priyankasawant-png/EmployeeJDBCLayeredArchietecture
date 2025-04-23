package com.capgemini.training.service;

import java.sql.SQLException;

import com.capgemini.training.businessbean.EmployeeBean;
import com.capgemini.training.dao.EmployeeDAO;
import com.capgemini.training.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public int insertEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int rowsUpdateCount=0;
		rowsUpdateCount = employeeDAO.insertEmployee(bean);
		
		return rowsUpdateCount;
		
		
	}

	@Override
	public void readEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		employeeDAO.readEmployee();
		
	}

	@Override
	public void updateEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		employeeDAO.updateEmployee(bean);
		
	}

	@Override
	public void deleteEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(bean);
		
	}
	

}
