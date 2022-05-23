package main;

import com.solvd.post.dao.models.Address;

import com.solvd.post.dao.service.OrderService;
import com.solvd.post.parsers.dom.TestDOM;
import com.solvd.post.parsers.jackson.TestJackson;
import com.solvd.post.parsers.jaxb.TextJAXB;
import com.solvd.post.parsers.json.TestJSON;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.post.dao.jdbcMYSQLimpl.AddressDAO;

public class Executer {
	private static final Logger LOGGER = LogManager.getLogger(Executer.class);

	public static void main(String[] args) {

        //		Address a = new Address();

        //  AddressDAO aDAO = new AddressDAO();
        //  aDAO.getEntityByJoin(2));
        
        	//	a = aDAO.getEntity(1);
		//  LOGGER.info(a.getAddress());
		//  a.setAddress("12 k 51");
		//  aDAO.updateEntity(a);

		//  aDAO.createEntity(a);

		//  aDAO.removeEntity(11);

		//  aDAO.getAllAddress().forEach(LOGGER::info);
         
		
		
		
		
        //	TestDOM.mainDOM();
		
		// TextJAXB.writerToXML();
		// LOGGER.info(TextJAXB.readerFromXml());

		
		//TestJackson.writeToJSON();
		//LOGGER.info(TestJackson.readFromJSON(1));
		

		// TestJSON.parseCars().forEach(LOGGER::info);		
	}

}
