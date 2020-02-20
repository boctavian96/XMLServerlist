package com.xml.serverlist.ServerListApp.homepage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/")
public class GreetingRestService {

	@GET
	@Path("/{name:.*}")
	public Response doGet(@PathParam("name") String name) {
		if (name == null || name.isEmpty()) {
			name = "World";
		}

		return Response.status(200).entity("Hello " + name + "!").build();

	}
	
	@GET
	@Path("/{name:.*}/{age:.*}")
	public Response doGreetAge(@PathParam("name") String name, @PathParam("age") String age) {
		if(name == null || age == null) {
			name = "World";
			age = "all the";
		}
		
		return Response.status(200).entity("Hello " + name + "!" + "\nYou have " + age + " years").build();
	}

}
