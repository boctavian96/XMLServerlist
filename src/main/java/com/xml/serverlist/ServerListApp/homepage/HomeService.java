package com.xml.serverlist.ServerListApp.homepage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class HomeService {

	@GET
	@Path("/")
	public Response getHomePage() {
		String serversList = "Form1</br>Form2</br>...";
		return Response.status(200).entity(serversList).build();
	}
	
	@GET
	@Path("/api_info")
	public Response getTheApi() {
		return Response.status(200).entity(ServicesConstants.API_INFO).build();
	}

}
