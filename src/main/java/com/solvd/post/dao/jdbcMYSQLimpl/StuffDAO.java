package com.solvd.post.dao.jdbcMYSQLimpl;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.solvd.post.dao.IStuffsDAO;
import com.solvd.post.dao.models.PostalOffice;
import com.solvd.post.dao.models.Stuff;

public class StuffDAO implements IStuffsDAO {

	 Stuff stuff = new Stuff();
   
	@Override
	public void createEntity(Stuff data) {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"INSERT INTO stuffs (firstName, lastName, position, phoneNumberl, PostalOffices_id)" + "VALUES (?,?,?,?,?);")) {

					pre.setString(1, stuff.getFirstName());
					pre.setString(2, stuff.getLastName());
					pre.setString(3, stuff.getPosition());
					pre.setInt(4, stuff.getPhoneNumber());
					pre.setLong(5, stuff.getPostalOfficesId());

					pre.executeUpdate();
					pre.close();
					con.close();

				}
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}


	}

	@Override
	public Stuff getEntity(long id) throws SQLException {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.stuffs WHERE id = ?")) {

					pre.setLong(1, id);

					try (ResultSet rs = pre.executeQuery()) {

						while (rs.next()) {
							stuff.setId(rs.getInt("id"));
							stuff.setFirstName(rs.getString("firstName"));
							stuff.setLastName(rs.getString("lastName"));
							stuff.setPosition(rs.getString("position"));
							stuff.setPhoneNumber(rs.getInt("phoneNumber"));
							stuff.setPostalOfficesId(rs.getLong("PostalOffices_id"));

						}
						rs.close();
						pre.close();
						con.close();
						return stuff;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return stuff;
	}

	@Override
	public void updateEntity(Stuff data) {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con
						.prepareStatement("UPDATE postmodel.stuffs set firstName = ?, lastName = ?, position = ?,"
								+ " phoneNumber = ?, PostalOffices_id = ? where id = ?;")) {

					pre.setString(1, stuff.getFirstName());
					pre.setString(2, stuff.getLastName());
					pre.setString(3, stuff.getPosition());
					pre.setInt(4, stuff.getPhoneNumber());
					pre.setLong(5, stuff.getPostalOfficesId());
					pre.setLong(6, stuff.getId());
					pre.executeUpdate();

					pre.close();
					con.close();

				}
			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

	@Override
	public void removeEntity(long id) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("DELETE FROM postmodel.stuffs WHERE id = ?")) {

					pre.setLong(1, id);
					pre.executeUpdate();
		
						pre.close();
						con.close();
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

	@Override
	public List<Stuff> getAllStuffs() {

		List<Stuff> allStuffs = new ArrayList<Stuff>();
		
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.stuffs")) {

					try (ResultSet rs = pre.executeQuery()) {

						while (rs.next()) {
							
							stuff.setId(rs.getInt("id"));
							stuff.setFirstName(rs.getString("firstName"));
							stuff.setLastName(rs.getString("lastName"));
							stuff.setPosition(rs.getString("position"));
							stuff.setPhoneNumber(rs.getInt("phoneNumber"));
							stuff.setPostalOfficesId(rs.getLong("PostalOffices_id"));
							allStuffs.add(stuff);
						}
						rs.close();
						pre.close();
						con.close();
						return allStuffs;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return allStuffs;

	}

	@Override
	public List<Stuff> getAllStuffsByPostalOffice(PostalOffice po) {
		List<Stuff> allStuffs = new ArrayList<Stuff>();
		
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.stuffs WHERE PostalOffices_id = ?")) {

					pre.setLong(1, po.getId());
					
					try (ResultSet rs = pre.executeQuery()) {

						while (rs.next()) {
							
							stuff.setId(rs.getInt("id"));
							stuff.setFirstName(rs.getString("firstName"));
							stuff.setLastName(rs.getString("lastName"));
							stuff.setPosition(rs.getString("position"));
							stuff.setPhoneNumber(rs.getInt("phoneNumber"));
							stuff.setPostalOfficesId(rs.getLong("PostalOffices_id"));
							allStuffs.add(stuff);
						}
						rs.close();
						pre.close();
						con.close();
						return allStuffs;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return allStuffs;

	}

}
