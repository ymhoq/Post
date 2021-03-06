package main;

import com.solvd.post.dao.models.Address;



import com.solvd.post.dao.service.OrderService;
import com.solvd.post.mybatis.datasource.DataSource;
import com.solvd.post.mybatis.mappers.CarDAOimpl;
import com.solvd.post.mybatis.po.Car;
import com.solvd.post.parsers.dom.TestDOM;
import com.solvd.post.parsers.jackson.TestJackson;
import com.solvd.post.parsers.jaxb.TextJAXB;
import com.solvd.post.parsers.json.TestJSON;

import listener.TestPaymentListener;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
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
		
		 //TextJAXB.writerToXML();
		// LOGGER.info(TextJAXB.readerFromXml());

		
		//TestJackson.writeToJSON();
		//LOGGER.info(TestJackson.readFromJSON(1));
		

		// TestJSON.parseCars().forEach(LOGGER::info);		
		
		CarDAOimpl carDAOimpl = new CarDAOimpl();
		try {
			//LOGGER.info(carDAOimpl.getEntity(3));
			carDAOimpl.createEntity(new Car());
			//carDAOimpl.removeEntity(3);
			//carDAOimpl.updateEntity(new Car());
			carDAOimpl.multiSearch().forEach(LOGGER::info);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//TestPaymentListener.test();
	
}
