package com.ensta.myfilmlist.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcDataSource;

public class ConnectionManager {
	private static final String DB_CONNECTION = "jdbc:h2:mem:testdb";
	private static final String DB_TEST = "jdbc:h2:~/MyFilmListDatabaseTest";
	
	
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "";

	private static JdbcDataSource datasource = null;
	private static JdbcDataSource datasourcetest = null;

	private static void init() {
		if (datasource == null) {
			datasource = new JdbcDataSource();
			datasource.setURL(DB_CONNECTION);
			datasource.setUser(DB_USER);
			datasource.setPassword(DB_PASSWORD);
		}
		if (datasourcetest == null) {
			datasourcetest = new JdbcDataSource();
			datasourcetest.setURL(DB_TEST);
			datasourcetest.setUser(DB_USER);
			datasourcetest.setPassword(DB_PASSWORD);
		}
	}

	public static Connection getConnectionForTest() throws SQLException {
		init();
		return datasourcetest.getConnection();
	}
	public static Connection getConnection() throws SQLException {
		init();
		return datasource.getConnection();
	}

}