package com.xml.serverlist.ServerListApp.database;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.xml.serverlist.ServerListApp.config.Config;

public class CreateVerticle{
	
	public void addNode(String id_e, String game_e, String name_e, String address_e, String players_e, String playersMax_e, String votes_e, String version_e) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(Config.DATABASE_FILE);
        Element root = document.getDocumentElement();

            // server elements
            Element newServer = document.createElement("server");
            
            Element id = document.createElement("id");
            id.appendChild(document.createTextNode(id_e));
            newServer.appendChild(id);
            
            Element game = document.createElement("game");
            game.appendChild(document.createTextNode(game_e));
            newServer.appendChild(game);

            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(name_e));
            newServer.appendChild(name);

            Element address = document.createElement("address");
            address.appendChild(document.createTextNode(address_e));
            newServer.appendChild(address);
            
            Element players = document.createElement("players");
            players.appendChild(document.createTextNode(players_e));
            newServer.appendChild(players);
            
            Element playersMax = document.createElement("playersMax");
            playersMax.appendChild(document.createTextNode(playersMax_e));
            newServer.appendChild(playersMax);
            
            Element version = document.createElement("version");
            version.appendChild(document.createTextNode(version_e));
            newServer.appendChild(version);

            root.appendChild(newServer);


        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(Config.DATABASE_FILE);
        transformer.transform(source, result);
    }
}
