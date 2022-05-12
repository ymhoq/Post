package com.solvd.post.parsers.dom;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
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

import com.solvd.post.dao.models.Address;

public class TestDOM {
	private static final Logger LOGGER = LogManager.getLogger(TestDOM.class);
	protected static Address address = new Address();

	public static void mainDOM(String[] args) {

		writeAddressToXML(getAddressDOMxml());

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
			System.out.println(addressChilds.item(i).getNodeName());

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
				address.getCity_id().setId(Integer.valueOf(cityChild.item(i).getTextContent()));
				break;
			}
			case "cityName": {
				address.getCity_id().setCityName(cityChild.item(i).getTextContent());
				break;
			}
			case "Country": {
				countryNode = cityChild.item(i);
				break;
			}

			}

		}

		NodeList childCountry = countryNode.getChildNodes();

		for (int i = 0; i < childCountry.getLength(); i++) {

			if (childCountry.item(i).getNodeType() != Node.ELEMENT_NODE
					|| childCountry.item(i).getTextContent().equals("")
					|| childCountry.item(i).getTextContent().equals(null)) {
				continue;
			}
			System.out.println(childCountry.item(i).getNodeName());

			switch (childCountry.item(i).getNodeName()) {

			case "id": {
				address.getCity_id().getCountry().setId(Integer.valueOf(childCountry.item(i).getTextContent()));
				break;
			}
			case "cityName": {
				address.getCity_id().getCountry().setName(childCountry.item(i).getTextContent());
				break;
			}
			}
		}

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

	private static Node getNodeElements(Document doc, Element element, String id, String name) {
		Element node = doc.createElement(id);
		node.appendChild(doc.createTextNode(id));
		node.appendChild(doc.createTextNode(name));
		return node;
	}

	private static Node getNodeElementsFinish(Document doc, Element element, String id, String address, String district,
			String postalCode) {
		Element node = doc.createElement(id);
		node.appendChild(doc.createTextNode(id));
		node.appendChild(doc.createTextNode(address));
		node.appendChild(doc.createTextNode(district));
		node.appendChild(doc.createTextNode(postalCode));
		return node;
	}

}
