package com.xml.serverlist.ServerListApp.homepage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/")
public class GreetingRestService {

	@GET
	@Path("/all")
	public Response getAllServers() {
		String serversList = "Server1</br>Server2</br>...";
		return Response.status(200).entity(serversList).build();
	}
	
	@GET
	@Path("/name/{name:.*}")
	public Response doGetName(@PathParam("name") String name) {
		if (name == null || name.isEmpty()) {
			name = "World";
		}

		return Response.status(200).entity("Hello " + name + "!").build();

	}
	
	@GET
	@Path("/address/{address:.*}")
	public Response doGetAddress(@PathParam("address") String address) {
		if(address == null || address.isEmpty()) {
			address = "localhost";
		}
		
		return Response.status(200).entity("Our address is: " + address).build();
	}
	
	@GET
	@Path("/tag/{tagname:.*}")
	public Response doGetTagname(@PathParam("tagname") String tag) {
		return Response.status(200).entity("fml").build(); 
	}

}
