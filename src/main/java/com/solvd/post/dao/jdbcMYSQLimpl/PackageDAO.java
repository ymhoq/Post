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

import com.solvd.post.dao.IPackagesDAO;
import com.solvd.post.dao.models.Address;
import com.solvd.post.dao.models.PackageBox;

public class PackageDAO implements IPackagesDAO {

	PackageBox pack = new PackageBox();

	@Override
	public void createEntity(PackageBox data) {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"INSERT INTO postmodel.packages ( options, insuranceAmount, status, Categorys_Id, Orders_Id )"
								+ "VALUES (?,?,?,?,?);")) {

					pre.setString(1, pack.getOptions());
					pre.setInt(2, pack.getInsuranceAmount());
					pre.setString(3, pack.getStatus());
					pre.setLong(4, pack.getCategory().getId());
					pre.setLong(5, pack.getOrder().getId());

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
	public PackageBox getEntity(long id) throws SQLException {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.packages WHERE id = ?")) {

					pre.setLong(1, id);

					try (ResultSet rs = pre.executeQuery()) {

						CategoryDAO catD = new CategoryDAO();
						OrderDAO oD = new OrderDAO();

						while (rs.next()) {
							pack.setId(rs.getLong("id"));
							pack.setOptions(rs.getString("options"));
							pack.setInsuranceAmount(rs.getInt("insuranceAmount"));
							pack.setStatus(rs.getString("status"));
							pack.setCategory(catD.getEntity(rs.getInt("Categorys_Id")));
							pack.setOrder(oD.getEntity(rs.getInt("Orders_Id")));
						}
						rs.close();
						pre.close();
						con.close();
						return pack;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return pack;
	}

	@Override
	public void updateEntity(PackageBox data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con
						.prepareStatement("UPDATE postmodel.packages set options = ?, insuranceAmount = ?,"
								+ " status = ?, Categorys_Id = ?, Orders_Id = ? where id = ?;")) {

					pre.setString(1, pack.getOptions());
					pre.setInt(2, pack.getInsuranceAmount());
					pre.setString(3, pack.getStatus());
					pre.setLong(4, pack.getCategory().getId());
					pre.setLong(5, pack.getOrder().getId());
					pre.setLong(6, pack.getId());
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

				try (PreparedStatement pre = con.prepareStatement("DELETE FROM postmodel.packages WHERE id = ?")) {

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
	public List<PackageBox> getAllPackages(long id) {

		List<PackageBox> allPackages = new ArrayList<PackageBox>();

		BaseDAO dao = new BaseDAO();
		try {
			ResultSet rs = dao.getResultSet("SELECT * FROM postmodel.packages");

			CategoryDAO catD = new CategoryDAO();
			OrderDAO oD = new OrderDAO();
			PackageBox pack = new PackageBox();

			while (rs.next()) {

				pack.setId(rs.getLong("id"));
				pack.setOptions(rs.getString("options"));
				pack.setInsuranceAmount(rs.getInt("insuranceAmount"));
				pack.setStatus(rs.getString("status"));
				pack.setCategory(catD.getEntity(rs.getInt("Categorys_Id")));
				pack.setOrder(oD.getEntity(rs.getInt("Orders_Id")));

				allPackages.add(pack);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			dao.closeAll();
		}
		return allPackages;
	}

}
