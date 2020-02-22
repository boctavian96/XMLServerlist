package com.xml.serverlist.ServerListApp.database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.dom4j.Document;
import org.dom4j.io.DOMReader;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.xml.serverlist.ServerListApp.config.Config;

public class ReadVerticle {

	public static List<String> readSource(String xPathExpression) {
		List<String> values = new ArrayList<>();
		File xmlDatabase = new File(Config.DATABASE_FILE);
		StringBuilder sb = new StringBuilder();
		DOMReader reader = new DOMReader();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		org.w3c.dom.Document doc;

		Document document = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlDatabase);
			document = reader.read(doc);

			XPath xPath = XPathFactory.newInstance().newXPath();

			NodeList nodeList = (NodeList) xPath.compile(xPathExpression).evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					values.add(element.getTextContent());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return values;
	}

}
