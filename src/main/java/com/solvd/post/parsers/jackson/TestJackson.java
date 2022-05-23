package com.solvd.post.parsers.jackson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.solvd.post.dao.jdbcMYSQLimpl.AddressDAO;
import com.solvd.post.dao.models.Address;

public class TestJackson {

	public static List<Address> readFromJSON(long id) {

		ObjectMapper om = new ObjectMapper();
		try {
			CollectionType type = om.getTypeFactory().constructCollectionType(List.class, Address.class);

			List<Address> address = om.readValue(new File("src/main/resources/json/alladdress.json"), type);

			if (address.isEmpty()) {
			} else
				return address;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

	public static void writeToJSON() {

		AddressDAO aDAO = new AddressDAO();
		aDAO.getAllAddress();

		ObjectMapper om = new ObjectMapper();

		File file = new File("src/main/resources/json/alladdress.json");
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		try {
			om.writeValue(file, aDAO.getAllAddress());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
