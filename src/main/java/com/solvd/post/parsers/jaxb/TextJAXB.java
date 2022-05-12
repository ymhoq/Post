package com.solvd.post.parsers.jaxb;

import java.io.File;

import java.util.ArrayList;

//Java EE packages
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.solvd.post.dao.jdbcMYSQLimpl.PostalOfficesDAO;
import com.solvd.post.dao.models.PostalOffice;

public class TextJAXB {

	private static PostalOfficesDAO poD = new PostalOfficesDAO();
	
	private static PostalOffice postalOffice = poD.getEntity(1);

	public static void writerToXML() {

		try {
			System.out.println();

			File file = new File("./postalOfficeJAXB" + postalOffice.getId() + ".xml");

			JAXBContext context = JAXBContext.newInstance(PostalOffice.class);

			Marshaller marshaller = context.createMarshaller();
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.marshal(postalOffice, file);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readerFromXml() {
	}

}
