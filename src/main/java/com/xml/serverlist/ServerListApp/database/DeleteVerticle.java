package com.xml.serverlist.ServerListApp.database;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import java.io.StringWriter;
import java.io.Writer;

public class DeleteVerticle {

	public void deleteNode(String id) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();

		// Document doc = db.parse(new FileInputStream(new File("in.xml")));

		// retrieve the element 'link'
		// Element element = (Element) doc.getElementsByTagName("link").item(0);

		// remove the specific node
		// element.getParentNode().removeChild(element);

		// Normalize the DOM tree, puts all text nodes in the
		// full depth of the sub-tree underneath this node
		// doc.normalize();

		// prettyPrint(doc);
	}

	public static final void prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
	}

}
