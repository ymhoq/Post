package com.solvd.post.dao.jdbcMYSQLimpl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDAO{

	private PreparedStatement statement;
	protected ResultSet resultSet;
	private Connection connection;

	public Connection getConnection() throws Throwable {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			MyConn.newInstance();
			connection = MyConn.getConnection(url, username, password);
		}
		return connection;
	}

	public ResultSet getResultSet(String sqlQuery) throws Throwable {
		getConnection();
		statement = connection.prepareStatement(sqlQuery);
		resultSet = statement.executeQuery();
		return resultSet;
	}
	
	
	
	
	

	public void closeAll() {
		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException ignored) {
			}
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException ignored) {
			}
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException ignored) {
			}
	}

}
