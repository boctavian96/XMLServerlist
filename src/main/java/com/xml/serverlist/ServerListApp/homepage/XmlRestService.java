package com.xml.serverlist.ServerListApp.homepage;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/")
public class XmlRestService {

	@GET
	@Path("/all")
	public Response getAllServers() {
		// TODO: Read this from xml.
		String serversList = "Server1</br>Server2</br>...";
		return Response.status(200).entity(serversList).build();
	}

	@GET
	@Path("/name/{name:.*}")
	public Response doGetName(@PathParam("name") String name) {
		// TODO: Get servers with the following name.
		if (name == null || name.isEmpty()) {
			name = "World";
		}

		return Response.status(200).entity("Hello " + name + "!").build();
	}

	@GET
	@Path("/address/{address:.*}")
	public Response doGetAddress(@PathParam("address") String address) {

		// TODO: Get servers with the following address.
		if (address == null || address.isEmpty()) {
			address = "localhost";
		}

		return Response.status(200).entity("Our address is: " + address).build();
	}

	@GET
	@Path("/tag/{tagname:.*}")
	public Response doGetTagname(@PathParam("tagname") String tag) {
		// TODO: Get all the servers with the following tag
		return Response.status(200).entity("fml").build();
	}

	@PUT
	@Path("/put/{servername:.*}/{address:.*}")
	public Response doPutNewServer(@PathParam("servername") String serverName, @PathParam("address") String address) {
		// TODO: Update the xml.
		return Response.status(200).entity("worked :D").build();
	}

	@DELETE
	@Path("/delete/{address:.*")
	public Response doDeleteServer() {
		// TODO: Delete server.
		return null;
	}

}
