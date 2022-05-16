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

import com.solvd.post.dao.ICarsDAO;
import com.solvd.post.dao.models.Car;

public class CarDAO implements ICarsDAO {

	Car car = new Car();

	@Override
	public void createEntity(Car data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con
						.prepareStatement("INSERT INTO cars (model, year, capasity)" + "VALUES (?,?,?);")) {

					pre.setString(1, car.getModel());
					pre.setInt(2, car.getYear());
					pre.setInt(3, car.getCapasity());

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
	public Car getEntity(long id) throws SQLException {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.cars WHERE id = ?")) {

					pre.setLong(1, id);

					try (ResultSet rs = pre.executeQuery()) {

						while (rs.next()) {
							car.setId(rs.getInt("idCars"));
							car.setModel(rs.getString("model"));
							car.setYear(rs.getInt("size"));
							car.setCapasity(rs.getInt("capasity"));
						}
						rs.close();
						pre.close();
						con.close();
						return car;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return car;
	}

	@Override
	public void updateEntity(Car data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"UPDATE postmodel.cars set model = ?, year = ?, capasity = ? where id = ?;")) {

					pre.setString(1, car.getModel());
					pre.setInt(2, car.getYear());
					pre.setInt(3, car.getCapasity());
					pre.setLong(4, car.getId());
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

				try (PreparedStatement pre = con.prepareStatement("DELETE FROM postmodel.cars WHERE id = ?")) {

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
	public List<Car> getAllCars(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
