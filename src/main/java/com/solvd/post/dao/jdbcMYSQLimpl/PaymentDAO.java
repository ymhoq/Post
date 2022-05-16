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

import com.solvd.post.dao.IPaymentsDAO;
import com.solvd.post.dao.models.Payment;

public class PaymentDAO implements IPaymentsDAO{

	Payment payment = new Payment();
	
	@Override
	public void createEntity(Payment data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement(
						"INSERT INTO payments (amount, paymentDate)" + "VALUES (?,?);")) {

					pre.setInt(1, payment.getAmount());
					pre.setDate(2, payment.getDate());

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
	public Payment getEntity(long id) throws SQLException {
		
		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con.prepareStatement("SELECT * FROM postmodel.payments WHERE id = ?")) {

					pre.setLong(1, id);

					try (ResultSet rs = pre.executeQuery()) {

						while (rs.next()) {
							payment.setId(rs.getLong("id"));
							payment.setAmount(rs.getInt("amount"));
							payment.setDate(rs.getDate("paymentDate"));
						}
						rs.close();
						pre.close();
						con.close();
						return payment;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return payment;

	}

	@Override
	public void updateEntity(Payment data) {

		Properties p = new Properties();
		try (InputStream resourceStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties")) {

			p.load(resourceStream);

			String url = p.getProperty("jdbc.url");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				try (PreparedStatement pre = con
						.prepareStatement("UPDATE postmodel.payments set amount = ?, paymentDate = ? where id = ?;")) {

					pre.setInt(1, payment.getAmount());
					pre.setDate(2, payment.getDate());
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

				try (PreparedStatement pre = con.prepareStatement("DELETE FROM postmodel.payments WHERE id = ?")) {

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
	public List<Payment> getAllPayments(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
