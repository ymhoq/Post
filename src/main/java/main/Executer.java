package main;

import com.solvd.post.dao.models.Address;
import com.solvd.post.dao.service.OrderService;
import com.solvd.post.parsers.dom.TestDOM;
import com.solvd.post.parsers.jaxb.TextJAXB;

import java.sql.SQLException;

import com.solvd.post.dao.jdbcMYSQLimpl.AddressDAO;

public class Executer {

	public static void main(String[] args) {

		Address a = new Address();

		AddressDAO aDAO = new AddressDAO();
		a = aDAO.getEntity(1);
		System.out.println(a.getAddress());
		a.setAddress("12 k 51");
		aDAO.updateEntity(a);

		aDAO.createEntity(a);

		aDAO.removeEntity(11);

		aDAO.getAllAddress().forEach(System.out::println);


		
		//TestDOM.mainDOM(args);

		TextJAXB.writerToXML();
	}

}
