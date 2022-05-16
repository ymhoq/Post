package com.solvd.post.parsers.dom;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.solvd.post.dao.jdbcMYSQLimpl.AddressDAO;
import com.solvd.post.dao.models.Address;
import com.solvd.post.dao.models.City;
import com.solvd.post.dao.models.Country;

public class TestDOM {
	private static final Logger LOGGER = LogManager.getLogger(TestDOM.class);
	protected static Address address = new Address(new City(new Country()));

	public static void mainDOM() {

		writeAddressToXML(getAddressDOMxml());

		AddressDAO addD = new AddressDAO();
		try {
			writeObjToXML(addD.getEntity(2));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Address getAddressDOMxml() {

		Node addressNode = getDoc().getFirstChild();
		NodeList addressChilds = addressNode.getChildNodes();

		Node cityNode = null;
		Node countryNode = null;

		for (int i = 0; i < addressChilds.getLength(); i++) {

			if (addressChilds.item(i).getNodeType() != Node.ELEMENT_NODE || addressChilds.item(i).getTextContent() == ""
					|| addressChilds.item(i).getTextContent() == null) {
				continue;
			}
			LOGGER.info(addressChilds.item(i).getNodeName());
			LOGGER.info(addressChilds.item(i).getTextContent());

			switch (addressChilds.item(i).getNodeName()) {

			case "id": {
				address.setId(Integer.valueOf((addressChilds.item(i).getTextContent())));
				break;
			}
			case "address": {
				address.setAddress(addressChilds.item(i).getTextContent());
				break;
			}
			case "district": {
				address.setDistrict(addressChilds.item(i).getTextContent());
				break;
			}
			case "postalCode": {
				address.setPostalCode(Integer.valueOf((addressChilds.item(i).getTextContent())));
				break;

			}
			case "City": {
				cityNode = addressChilds.item(i);
				break;
			}

			}

		}

		NodeList cityChild = cityNode.getChildNodes();

		for (int i = 0; i < cityChild.getLength(); i++) {

			if (cityChild.item(i).getNodeType() != Node.ELEMENT_NODE || cityChild.item(i).getTextContent() == ""
					|| cityChild.item(i).getTextContent() == null) {
				continue;
			}
			System.out.println(cityChild.item(i).getNodeName());

			switch (cityChild.item(i).getNodeName()) {

			case "id": {
				address.getCity().setId(Integer.valueOf(cityChild.item(i).getTextContent()));
				break;
			}
			case "name": {
				address.getCity().setCityName(cityChild.item(i).getTextContent());
				break;
			}
			case "Country": {
				countryNode = cityChild.item(i);
				break;
			}
			}

		}

		NodeList childCountry = countryNode.getChildNodes();

		for (int j = 0; j < childCountry.getLength(); j++) {

			if (childCountry.item(j).getNodeType() != Node.ELEMENT_NODE
					|| childCountry.item(j).getTextContent().equals("")
					|| childCountry.item(j).getTextContent().equals(null)) {
				continue;
			}
			System.out.println(childCountry.item(j).getNodeName());

			switch (childCountry.item(j).getNodeName()) {

			case "id": {
				address.getCity().getCountry().setId(Integer.valueOf(childCountry.item(j).getTextContent()));
				break;
			}
			case "name": {
				address.getCity().getCountry().setName(childCountry.item(j).getTextContent());
				break;
			}
			}
		}

		System.out.println(address);
		return address;

	}

	private static void writeAddressToXML(Address address) {

		try {
			FileOutputStream fos = new FileOutputStream(new File("./address" + address.getId() + ".xml"));
			try (XMLEncoder encoder = new XMLEncoder(fos)) {
				encoder.writeObject(address);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Document getDoc() {

		File file = new File("src/main/resources/xml/address.xml");
		DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
		Document doc = null;
		try {
			return doc = dBF.newDocumentBuilder().parse(file);
		} catch (SAXException | ParserConfigurationException | IOException e) {
			LOGGER.error(e);
		}

		return null;

	}

	private static Node createAddress(Document doc, Address address) {

		Element addressE = doc.createElement("Address");

		addressE.setAttribute("id", address.getId() + "");
		addressE.appendChild(createElement(doc, "address", address.getAddress()));
		addressE.appendChild(createElement(doc, "district", address.getDistrict()));
		addressE.appendChild(createElement(doc, "postalCode", address.getPostalCode() + ""));

		Element cityE = doc.createElement("City");
		cityE.setAttribute("id", address.getCity().getId() + "");
		cityE.appendChild(createElement(doc, "name", address.getCity().getCityName()));

		Element countryE = doc.createElement("Country");
		countryE.setAttribute("id", address.getCity().getCountry().getId() + "");
		countryE.appendChild(createElement(doc, "name", address.getCity().getCountry().getName()));
		cityE.appendChild(countryE);

		addressE.appendChild(cityE);
		return addressE;
	}

	

	private static Node createElement(Document doc, String name, String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}

	
	public static void writeObjToXML(Address address) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element root = doc.createElementNS("project.POST", "Address");
		doc.appendChild(root);

		root.appendChild(createAddress(doc, address));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();

		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		DOMSource source = new DOMSource(doc);

		File myFile = new File("src/main/resources/addressByDOM.xml");

		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);

		transf.transform(source, console);
		transf.transform(source, file);
	}

}
