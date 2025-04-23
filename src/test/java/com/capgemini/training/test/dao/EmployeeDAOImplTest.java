package com.capgemini.training.test.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.training.businessbean.EmployeeBean;
import com.capgemini.training.dao.EmployeeDAO;
import com.capgemini.training.dao.EmployeeDAOImpl;

public class EmployeeDAOImplTest {
	private EmployeeDAO employeeDAO;
	@BeforeEach
	public void setUp() {
		employeeDAO = new EmployeeDAOImpl();
	}
	//@Test
	public void testInsertEmployee() throws SQLException, ClassNotFoundException{
		EmployeeBean bean = new EmployeeBean();
		bean.setEmployeeId(1010);
		bean.setEmployeeName("Hindu Jayasree");
		bean.setRole("Tester");
		bean.setInsertTime(new Date());  //import java.util.date
		bean.setSalary(120000.0);
		int rowsInserted = employeeDAO.insertEmployee(bean);
		assertEquals(1,rowsInserted);
	}
	
	 @Test
	 public void testReadEmployee() throws SQLException, ClassNotFoundException{
		 assertDoesNotThrow(()->employeeDAO.readEmployee());
	 }
	
	 @Test 
	 public void testUpdateEmployee() throws SQLException, ClassNotFoundException{
		 EmployeeBean bean = new EmployeeBean(); bean.setEmployeeId(1001);
		 bean.setSalary(130000.0);
		 assertDoesNotThrow(()->employeeDAO.updateEmployee(bean)); 
	}
	
	 @Test 
	 public void testDeleteEmployee() throws SQLException,ClassNotFoundException{ 
		 EmployeeBean bean = new EmployeeBean();
		 bean.setEmployeeId(1009);
		 assertDoesNotThrow(()->employeeDAO.deleteEmployee(bean));
		 }
	 
}