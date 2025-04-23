package com.capgemini.training.dao;

import java.sql.Connection;
//whenever in dao layer should use java.sql.date instead of java.util.date, everywhere else java.util.date only
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.training.businessbean.EmployeeBean;
import com.capgemini.training.utility.DBUtility;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Connection connection = null;
	private static Statement st = null;

	@Override
	public int insertEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		try {
			int rowsUpdateCount = 0;
			int id = bean.getEmployeeId();
			String ename = bean.getEmployeeName();
			String role = bean.getRole();
			Date insertTime = new Date(bean.getInsertTime().getTime());
			double salary = bean.getSalary();
			String insertdata = "insert into employee" + " values('" + id + "','" + ename + "','" + role + "','"
					+ insertTime + "','" + salary + "')";
			connection = DBUtility.getDBConnection();
			st = connection.createStatement();
			rowsUpdateCount = st.executeUpdate(insertdata);
			if (rowsUpdateCount > 0) {
				System.out.println("Employee registered successfully:" + rowsUpdateCount);
			} else {
				System.out.println("OOps some thing went wrong!! we are on process..");
			}
			return rowsUpdateCount;
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtility.getDBConnectionClose();
		}
	}

	@Override
	public void readEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	}
	@Override
	public void updateEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			int id = bean.getEmployeeId();
			double modifiedsalary = bean.getSalary();
			String updatedata = "update employee set salary=" + 
			modifiedsalary + "where employeeid= '" + id + "'";
			connection = DBUtility.getDBConnection();
			st = connection.createStatement();
			int rowsUpdateCount = st.executeUpdate(updatedata);
			if (rowsUpdateCount > 0) {
				System.out.println("Employee Updated successfully: " + rowsUpdateCount);
			} else {
				System.out.println("Oops some thing went wrong!! we are on process..");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtility.getDBConnectionClose();
		}
	}
	@Override
	public void deleteEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		try {
			int id = bean.getEmployeeId();
			String deletedata = "DELETE from employee WHERE employeeId = '" + id + "'";
			connection =DBUtility.getDBConnection();
			st = connection.createStatement();
			int deleteRowsUpdateCount = st.executeUpdate(deletedata);
			if(deleteRowsUpdateCount>0) {
				System.out.println("Employee deleted succesfully: "+deleteRowsUpdateCount);
			}
			else {
				System.out.println("Oops some thing went wrong!! we are on process..");
			}
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			DBUtility.getDBConnectionClose();
		}

	}

}
