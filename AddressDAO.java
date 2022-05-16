package com.solvd.post.dao.jdbcMYSQLimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.solvd.post.dao.IAddressDAO;
import com.solvd.post.dao.models.Address;
import com.solvd.post.dao.models.City;
import com.solvd.post.dao.models.Country;

public class AddressDAO extends BaseDAO implements IAddressDAO {

	Address address = new Address();

	@Override
	public void createEntity(Address data) {

		BaseDAO dao = new BaseDAO();

		try (PreparedStatement pre = dao.getConnection().prepareStatement(
				"INSERT INTO address (address, district, postalCode, Citys_id)" + "VALUES (?,?,?,?);")) {

			pre.setString(1, address.getAddress());
			pre.setString(2, address.getDistrict());
			pre.setInt(3, address.getPostalCode());
			pre.setLong(4, address.getCity().getId());

			pre.executeUpdate();
			pre.close();

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			dao.closeAll();
		}

	}

	@Override
	public Address getEntity(long id) {

		BaseDAO dao = new BaseDAO();

		try (PreparedStatement pre = dao.getConnection()
				.prepareStatement("SELECT * FROM postmodel.address WHERE id = ?")) {

			pre.setLong(1, id);

			try (ResultSet rs = pre.executeQuery()) {
				CityDAO cityD = new CityDAO();
				while (rs.next()) {
					address = new Address();
					address.setId(rs.getInt("id"));
					address.setAddress(rs.getString("address"));
					address.setDistrict(rs.getString("district"));
					address.setPostalCode(rs.getInt("postalCode"));
					address.setCity(cityD.getEntity(rs.getLong("Citys_id")));
				}
				return address;
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.closeAll();
		}

		return address;

	}

	public Address getEntityByJoin(long id) {

		BaseDAO dao = new BaseDAO();

		try (PreparedStatement pre = dao.getConnection().prepareStatement(
				"SELECT address.id, address.Citys_id, citys.id, citys.name, citys.Countrys_id FROM address \r\n"
						+ "INNER JOIN citys ON address.Citys_id=citys.id WHERE address.id = ?;")) {

			pre.setLong(1, id);

			try (ResultSet rs = pre.executeQuery()) {
				CountryDAO countyD = new CountryDAO();
				while (rs.next()) {
					address = new Address();
					address.setId(rs.getInt("id"));
					address.setAddress(rs.getString("address"));
					address.setDistrict(rs.getString("district"));
					address.setCity(new City(rs.getLong("Citys_id"), rs.getString("name"),
							countyD.getEntity(rs.getLong("Countrys_id"))));

				}
				return address;
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.closeAll();
		}

		return address;

	}

	@Override
	public void updateEntity(Address data) {

		BaseDAO dao = new BaseDAO();

		try (PreparedStatement pre = dao.getConnection()
				.prepareStatement("UPDATE postmodel.address set address = ?, district = ?, postalCode = ?,"
						+ " Citys_id = ? where id = ?;")) {

			pre.setString(1, address.getAddress());
			pre.setString(2, address.getDistrict());
			pre.setInt(3, address.getPostalCode());
			pre.setLong(4, address.getCity().getId());
			pre.setLong(5, address.getId());
			pre.executeUpdate();

			pre.close();

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			dao.closeAll();
		}

	}

	@Override
	public void removeEntity(long id) {
		BaseDAO dao = new BaseDAO();
		try (PreparedStatement pre = dao.getConnection()
				.prepareStatement("DELETE FROM postmodel.address WHERE id = ?")) {

			pre.setLong(1, id);
			pre.executeUpdate();

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Address> getAllAddress() {

		List<Address> allAddress = new ArrayList<Address>();

		BaseDAO dao = new BaseDAO();
		try {
			ResultSet rs = dao.getResultSet("SELECT * FROM postmodel.address");

			while (rs.next()) {
				CityDAO cityD = new CityDAO();
				allAddress.add(new Address(rs.getInt("id"), rs.getString("address"), rs.getString("district"),
						rs.getInt("postalCode"), cityD.getEntity(rs.getLong("Citys_id"))));
			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			dao.closeAll();
		}
		return allAddress;

	}
}
