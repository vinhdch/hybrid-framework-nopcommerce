package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {
	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "011296";

		return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";instance=" + sqlInstanceName;

			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
