package com.xml.serverlist.ServerListApp.homepage;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.xml.serverlist.ServerListApp.database.CreateVerticle;
import com.xml.serverlist.ServerListApp.database.DeleteVerticle;
import com.xml.serverlist.ServerListApp.database.ReadVerticle;
import com.xml.serverlist.html.TableBuilder;

@Path("/xml")
public class XmlRestService {

	@GET
	@Path("/all")
	public Response getAllServers() {
		List<String> rawXml = ReadVerticle.readSource("/database/server");
		TableBuilder tb = new TableBuilder();
		tb.appendCol(rawXml);
		return Response.status(200).entity(tb.buildTable()).build();
	}

	@GET
	@Path("/name/{name:.*}")
	public Response doGetName(@PathParam("name") String game) {
		List<String> rawXml = ReadVerticle.readSource("/database/server[game ='" + game + "']");
		if (game == null || game.isEmpty()) {
			game = "World";
		}
		TableBuilder tb = new TableBuilder();
		tb.appendCol(rawXml);

		return Response.status(200).entity(tb.buildTable()).build();
	}

	@GET
	@Path("/address/{address:.*}")
	public Response doGetAddress(@PathParam("address") String address) {
		List<String> rawXml = ReadVerticle.readSource("/database/server[address='" + address + "']");
		if (address == null || address.isEmpty()) {
			address = "World";
		}
		TableBuilder tb = new TableBuilder();
		tb.appendCol(rawXml);

		return Response.status(200).entity(tb.buildTable()).build();
	}

	@PUT
	@Path("/put/{id:.*}/{game:.*}/{servername:.*}/{address:.*}/{players:.*}/{playersMax:.*}/{votes:.*}/{version:.*}")
	public Response doPutNewServer(@PathParam("id") String id, @PathParam("game") String game,
			@PathParam("servername") String serverName, @PathParam("address") String address,
			@PathParam("players") String players, @PathParam("playersMax") String playersMax,
			@PathParam("votes") String votes, @PathParam("version") String version) {

		try {
			CreateVerticle cv = new CreateVerticle();
			cv.addNode(id, game, serverName, address, players, playersMax, votes, version);

			return Response.status(200).entity("Added a new node in the database with id: " + id).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(200).entity("Failure").build();
		}
	}

	@DELETE
	@Path("/delete/{id:.*}")
	public Response doDeleteServer(@PathParam("id") String id) {
		try {
			DeleteVerticle dv = new DeleteVerticle();
			dv.deleteNode(id);
			return Response.status(200).entity("Deleted the entry with id: " + id).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(200).entity("Deleted the entry with id: " + id).build();
		}
	}

	@GET
	@Path("/test_tb")
	public Response doGetDummyDatabase() {
		// Just list the servers raw
		TableBuilder tb = new TableBuilder();

		List<String> lista = new ArrayList<>();
		lista.add("A");
		lista.add("A");
		lista.add("A");
		lista.add("A");
		lista.add("A");
		lista.add("A");
		lista.add("A");
		lista.add("B");
		lista.add("B");
		lista.add("B");
		lista.add("B");
		lista.add("B");
		lista.add("B");
		lista.add("B");
		lista.add("C");
		lista.add("C");
		lista.add("C");
		lista.add("C");
		lista.add("C");
		lista.add("C");
		lista.add("C");

		tb.appendCol(lista);
		String html = tb.buildTable();

		return Response.status(200).entity(html).build();
	}

	@GET
	@Path("/raw")
	public Response doGetRawDatabase() {
		// Just list the servers raw
		List<String> rawXml = ReadVerticle.readSource("/database/server");
		StringBuilder rawRaw = new StringBuilder();
		for (String xml : rawXml) {
			rawRaw.append(xml);
		}

		return Response.status(200).entity(rawRaw.toString()).build();
	}

	@GET
	@Path("/dummy_table")
	public Response doGetDummyTable() {
		// Just list the servers raw
		String dummyTable = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<style>\n" + "table {\n"
				+ "  font-family: arial, sans-serif;\n" + "  border-collapse: collapse;\n" + "  width: 100%;\n" + "}\n"
				+ "\n" + "td, th {\n" + "  border: 1px solid #dddddd;\n" + "  text-align: left;\n" + "  padding: 8px;\n"
				+ "}\n" + "\n" + "tr:nth-child(even) {\n" + "  background-color: #dddddd;\n" + "}\n" + "</style>\n"
				+ "</head>\n" + "<body>\n" + "\n" + "<h2>Servers List</h2>\n" + "\n" + "<table>\n" + "  <tr>\n"
				+ "    <th>Game</th>\n" + "    <th>Name</th>\n" + "    <th>Address</th>\n" + "    <th>Players</th>\n"
				+ "    <th>Max Players</th>\n" + "    <th>Votes</th>\n" + "    <th>Version</th>\n" + "  </tr>\n"
				+ "  <tr>\n" + "    <td>Minecraft</td>\n" + "    <td>MineCraft Superior</td>\n"
				+ "    <td>hub.mcs.gg</td>\n" + "    <td>1234</td>\n" + "    <td>8000</td>\n" + "    <td>4233</td>\n"
				+ "    <td>1.15.1</td>\n" + "  </tr>\n" + "    <tr>\n" + "    <td>Minecraft</td>\n"
				+ "    <td>MineCraft Superior</td>\n" + "    <td>hub.mcs.gg</td>\n" + "    <td>1234</td>\n"
				+ "    <td>8000</td>\n" + "    <td>4233</td>\n" + "    <td>1.15.1</td>\n" + "  </tr>\n" + "</table>\n"
				+ "\n" + "</body>\n" + "</html>";
		return Response.status(200).entity(dummyTable).build();
	}

}
