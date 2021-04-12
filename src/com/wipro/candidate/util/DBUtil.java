package com.wipro.candidate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	public static Connection getDBConn() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/wiprodata";
		String userName = "root";
		String password = "";
		Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
		return connection;
	}
}
