package com.solvd.post.dao.jdbcMYSQLimpl;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.solvd.post.dao.IPostalOfficesDAO;
import com.solvd.post.dao.models.PostalOffice;

public class PostalOfficesDAO implements IPostalOfficesDAO {

	PostalOffice postalOffice = new PostalOffice();

	@Override
	public void createEntity(PostalOffice data) {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con
						.prepareStatement("INSERT INTO postaloffices (phone, type, Address_id)" + "VALUES (?,?,?);")) {

					pre.setInt(1, postalOffice.getPhone());
					pre.setString(2, postalOffice.getType());
					pre.setLong(3, postalOffice.getAddress().getId());

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
	public PostalOffice getEntity(long id) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con
						.prepareStatement("SELECT * FROM postmodel.postaloffices WHERE id = ?")) {

					pre.setLong(1, id);

					try (ResultSet rs = pre.executeQuery()) {
						AddressDAO addressD = new AddressDAO();
						while (rs.next()) {
							postalOffice.setId(rs.getLong("id"));
							postalOffice.setPhone(rs.getInt("phone"));
							postalOffice.setType(rs.getString("type"));
							postalOffice.setAddress(addressD.getEntity(rs.getInt("Address_id")));
						}
						rs.close();
						pre.close();
						con.close();
						return postalOffice;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return postalOffice;

	}

	@Override
	public void updateEntity(PostalOffice data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"UPDATE postmodel.postaloffices set phone = ?," + " type = ?, Address_id = ? where id = ?;")) {

					pre.setInt(1, postalOffice.getPhone());
					pre.setString(2, postalOffice.getType());
					pre.setLong(3, postalOffice.getAddress().getId());
					pre.setLong(4, postalOffice.getId());
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

				try (PreparedStatement pre = con.prepareStatement("DELETE FROM postmodel.postaloffices WHERE id = ?")) {

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
	public List<PostalOffice> getAllPostalOffices(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
