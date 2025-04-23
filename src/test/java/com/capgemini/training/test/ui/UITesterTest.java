package com.capgemini.training.test.ui;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.training.businessbean.EmployeeBean;
import com.capgemini.training.service.EmployeeServiceImpl;
import com.capgemini.training.ui.UITester;

public class UITesterTest {
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	@Mock
	private EmployeeServiceImpl mockService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		//UITester.main(null);
	}

	/*@Test
	public void testInsertEmployee() throws ClassNotFoundException, SQLException, Exception {
		doNothing().when(mockService).insertEmployee(any(EmployeeBean.class));
		UITester.insertEmployee();
		verify(mockService, atLeastOnce()).insertEmployee(any(EmployeeBean.class));
	}*/

	@Test
	public void testReadEmployee() throws ClassNotFoundException, SQLException {
		doNothing().when(mockService).readEmployee();
		UITester.readEmployee();
		verify(mockService, atLeastOnce()).readEmployee();
	}

	@Test 
	 public void testUpdateEmployee() throws ClassNotFoundException,SQLException{ 
		doNothing().when(mockService).updateEmployee(any(EmployeeBean.class));
		UITester.updateEmployee();
		verify(mockService, atLeastOnce()).updateEmployee(any(EmployeeBean.class)); 
		}
	@Test
	public void testDeleteEmployee() throws ClassNotFoundException,SQLException{ 
		doNothing().when(mockService).deleteEmployee(any(EmployeeBean.class));
		UITester.deleteEmployee();
		verify(mockService, atLeastOnce()).deleteEmployee(any(EmployeeBean.class)); 
		}

}
