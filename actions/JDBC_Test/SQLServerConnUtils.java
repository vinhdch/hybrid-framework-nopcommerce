package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnUtils {

	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "P@ss!!!";

		return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" + database;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
