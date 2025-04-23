package com.capgemini.training.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.training.businessbean.EmployeeBean;
import com.capgemini.training.dao.EmployeeDAO;
import com.capgemini.training.service.EmployeeServiceImpl;

class EmployeeServiceImplTest {

	// ctrl+shift+/
	@Mock
	private EmployeeDAO employeeDAO;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void testInsertEmployee_Success() throws SQLException, ClassNotFoundException{
		EmployeeBean employee = new EmployeeBean();
		employee.setEmployeeId(1005);
		employee.setEmployeeName("Japan Jennifer Joseph");
		employee.setRole("Analyst");
		employee.setSalary(150000.0);
		employee.setInsertTime(new java.util.Date());
		
		when(employeeDAO.insertEmployee(employee)).thenReturn(1);
		when(employeeDAO.insertEmployee(employee)).thenReturn(2);
		int result= employeeService.insertEmployee(employee);
		assertEquals(2,result);
		verify(employeeDAO,times(1)).insertEmployee(employee);
	}
	
	
	@Test
	public void testInsertEmployee_Failure() throws SQLException, ClassNotFoundException{
		EmployeeBean employee = new EmployeeBean();
		employee.setEmployeeId(1004);
		when(employeeDAO.insertEmployee(employee)).thenThrow(new SQLException("Insertion failed"));
		Exception exception = assertThrows(SQLException.class,()->{
			employeeService.insertEmployee(employee);
		});
		assertEquals("Insertion failed",exception.getMessage());
		//assertEquals("Insertion failed","success");
	}
	
	@Test
	public void testReadEmployee() throws SQLException, ClassNotFoundException{
		employeeService.readEmployee();
		verify(employeeDAO,times(1)).readEmployee();
	}
	
	@Test
	public void testUpdateEmployee_Success() throws SQLException, ClassNotFoundException{
		EmployeeBean employee = new EmployeeBean();
		employee.setEmployeeId(1002);
		employee.setSalary(200000.0);
		employeeService.updateEmployee(employee);
		verify(employeeDAO,times(1)).updateEmployee(employee);
	}

	@Test
	public void testDeleteEmployee_Success() throws SQLException, ClassNotFoundException{
		EmployeeBean employee = new EmployeeBean();
		employee.setEmployeeId(1004);
		employeeService.deleteEmployee(employee);
		verify(employeeDAO,times(1)).deleteEmployee(employee);
	}
	
	
	

}
