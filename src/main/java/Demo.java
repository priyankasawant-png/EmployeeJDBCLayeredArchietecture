import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Demo {
	
	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded succesfully");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded succesfully");
		}
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemos", "root", "Rupini@123");
			System.out.println("Connection established succesfully");
			Statement st = con.createStatement();
			//String cs = "CREATE TABLE EMP (Empid int,Empname char(20), Empsal int)";
			//st.execute(cs);
//			String cs = "insert into emp values(1001,'Hindu Jayasree Japan',30000)";
//			st.execute(cs);
//			 cs = "insert into emp values(1002,'Sonaleo',25000)";
//			st.execute(cs);
//			 cs = "insert into emp values(1001,'Trisha',30000)";
//			st.execute(cs);
//			String cs ="Select * from EMP";
//			ResultSet rs = st.executeQuery(cs);
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int col = rsmd.getColumnCount();
//			while(rs.next()) {
//				for(int i=1;i<=col;i++) {
//					String s = rs.getString(i);
//					System.out.print(s+" ");
//				}
//				System.out.println();
//			}
			try {
			con.setAutoCommit(false);
			String cs = "insert into emp values(1005,'Rupini',33000)";
			st.executeUpdate(cs);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter an employee id to delete");
			int r = Integer.parseInt(br.readLine());
			String cs1 = "Delete from emp where empid =" +r;
			int status = st.executeUpdate(cs1);
			con.commit();
			con.setAutoCommit(true);
			if(status==0) {
				System.out.println("Record does not exist");
			}
			else {
				System.out.println(status+"Records are deleted");
			}
			
			}
			catch(IOException e) {
				
			}
		
		}
		catch(SQLException e) {
			System.out.println("Connection established unsuccesful");

		}
	}
	

}
