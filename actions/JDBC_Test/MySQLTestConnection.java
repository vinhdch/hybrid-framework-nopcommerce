package JDBC_Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection... ");

		Connection conn = MySQLTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);

		Statement statement = conn.createStatement();

		// String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";
		String sql = "SELECT * FROM wp_users";

		ResultSet rs = statement.executeQuery(sql);

		// while (rs.next()) {
		//
		// int empId = rs.getInt(1);
		// String empFirstName = rs.getString(2);
		// String empLastName = rs.getString("Last_Name");
		//
		// System.out.println("--------------------");
		// System.out.println("Emp Id:" + empId);
		// System.out.println("Emp Firstname:" + empFirstName);
		// System.out.println("Emp Lastname:" + empLastName);
		// }

		while (rs.next()) {

			int userID = rs.getInt(1);
			String userLogin = rs.getString(2);
			String userEmail = rs.getString("user_email");

			System.out.println("--------------------");
			System.out.println("Emp Id:" + userID);
			System.out.println("Emp userLogin:" + userLogin);
			System.out.println("Emp userEmail:" + userEmail);
		}

		conn.close();
		System.out.println("---------- Closed connection ----------");
	}
}
