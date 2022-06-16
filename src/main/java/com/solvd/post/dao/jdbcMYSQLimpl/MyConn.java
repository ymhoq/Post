package com.solvd.post.dao.jdbcMYSQLimpl;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class MyConn {

	private static MyConn instance;

	public MyConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public static MyConn newInstance() {
		if (instance == null)
			new MyConn();
		return instance;
	}

	public static Connection getConnection(String url, String username, String password) {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			
		}

		return null;
	}
	/*
	 * static Connection action() { Properties p = new Properties(); InputStream
	 * resourceStream = Thread.currentThread().getContextClassLoader()
	 * .getResourceAsStream("db.properties");
	 * 
	 * p.load(resourceStream);
	 * 
	 * String url = p.getProperty("jdbc.url"); String username =
	 * p.getProperty("jdbc.username"); String password =
	 * p.getProperty("jdbc.password");
	 * 
	 * Connection con = DriverManager.getConnection(url, username, password);
	 * 
	 * return con;
	 * 
	 * }
	 */
}