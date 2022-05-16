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

import com.solvd.post.dao.IRouteSheetDAO;
import com.solvd.post.dao.models.RouteSheet;

public class RouteSheetDAO implements IRouteSheetDAO {

	RouteSheet routeSheet = new RouteSheet();

	@Override
	public void createEntity(RouteSheet data) {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"INSERT INTO routesheets (ÑargoLists_id, Cars_idCars, Stuffs_id)" + "VALUES (?,?,?);")) {

					pre.setLong(1, routeSheet.getCargoList().getId());
					pre.setLong(2, routeSheet.getCar().getId());
					pre.setLong(3, routeSheet.getStuff().getId());

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
	public RouteSheet getEntity(long id) throws SQLException {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.routesheets WHERE id = ?")) {

					pre.setLong(1, id);

					try (ResultSet rs = pre.executeQuery()) {

						CargoListDAO cListD = new CargoListDAO();
						CarDAO carsD = new CarDAO();
						StuffDAO sD = new StuffDAO();

						while (rs.next()) {
							routeSheet.setId(rs.getInt("id"));
							routeSheet.setCargoList(cListD.getEntity(rs.getInt("CargoLists_id")));
							routeSheet.setCar(carsD.getEntity(rs.getInt("Cars_idCars")));
							routeSheet.setStuff(sD.getEntity(rs.getInt("Stuffs_id")));
						}
						rs.close();
						pre.close();
						con.close();
						return routeSheet;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return routeSheet;
	}

	@Override
	public void updateEntity(RouteSheet data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("UPDATE postmodel.routesheets set CargoLists_id = ?,"
						+ " Cars_idCars = ?, Stuffs_id = ? WHERE id = ?;")) {

					pre.setLong(1, routeSheet.getCargoList().getId());
					pre.setLong(2, routeSheet.getCar().getId());
					pre.setLong(3, routeSheet.getStuff().getId());
					pre.setLong(4, routeSheet.getId());
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

				try (PreparedStatement pre = con.prepareStatement("DELETE FROM postmodel.routesheets WHERE id = ?")) {

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
	public List<RouteSheet> getAllRouteSheets(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
