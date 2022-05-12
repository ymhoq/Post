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

import com.solvd.post.dao.IOrdersDAO;
import com.solvd.post.dao.models.Address;
import com.solvd.post.dao.models.Order;

public class OrderDAO implements IOrdersDAO {

	Order order = new Order();

	@Override
	public void createEntity(Order data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"INSERT INTO orders (createDate, sender_id, recepient_id, Paymenrs_id, Stuffs_id)"
								+ "VALUES (?,?,?,?,?);")) {

					pre.setDate(1, order.getCreateDate());
					pre.setInt(2, order.getSenderId());
					pre.setInt(3, order.getRecipientId());
					pre.setLong(4, order.getPayment().getId());
					pre.setLong(5, order.getStuff().getId());

					pre.executeUpdate();
					pre.close();
					con.close();

				}
			}

		} catch (SQLException | IOException e) {

			e.printStackTrace();
		} finally {

		}

	}

	@Override
	public Order getEntity(long id) throws SQLException {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.orders WHERE id = ?")) {

					pre.setLong(1, id);

					try (ResultSet rs = pre.executeQuery()) {

						while (rs.next()) {
							order.setId(rs.getLong("id"));
							order.setCreateDate(rs.getDate("createDate"));
							order.setSenderId(rs.getInt("sender_id"));
							order.setRecipientId(rs.getInt("recepient_id"));
						//	order.getPayment().setId(rs.getLong("Payments_id"));
						//	order.getStuff().setId(rs.getInt("Stuffs_id"));
						}
						rs.close();
						pre.close();
						con.close();
						return order;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return order;

	}

	@Override
	public void updateEntity(Order data) {
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"UPDATE postmodel.orders set createDate = ?, sender_id = ?, recepient_id = ?, Paymenrs_id = ?, Stuffs_id = ? where id = ?;")) {

					pre.setDate(1, order.getCreateDate());
					pre.setInt(2, order.getSenderId());
					pre.setInt(3, order.getRecipientId());
					pre.setLong(4, order.getPayment().getId());
					pre.setLong(5, order.getStuff().getId());
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

				try (PreparedStatement pre = con.prepareStatement("DELETE FROM postmodel.orders WHERE id = ?")) {

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
	public List<Order> getAllOrdersByCustomer(long id) {

		List<Order> allOrdersByCustomer = new ArrayList<Order>();

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.orders where sender_id = ?;")) {

					pre.setLong(1, id);
					try (ResultSet rs = pre.executeQuery()) {

						while (rs.next()) {
							Order order = new Order();
							order.setId(rs.getLong("id"));
							order.setCreateDate(rs.getDate("createDate"));
				        	order.setSenderId(rs.getInt("sender_id"));
							order.setRecipientId(rs.getInt("recepient_id"));
							order.getPayment().setId(rs.getInt("Payments_id"));
							order.getStuff().setId(rs.getInt("Stuffs_id"));
							allOrdersByCustomer.add(order);
						}
						rs.close();
						pre.close();
						con.close();
						return allOrdersByCustomer;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return allOrdersByCustomer;

	}

}
