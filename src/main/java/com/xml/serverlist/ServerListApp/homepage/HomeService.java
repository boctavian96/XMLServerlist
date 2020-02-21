package com.xml.serverlist.ServerListApp.homepage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.xml.serverlist.ServerListApp.database.ReadVerticle;

@Path("/")
public class HomeService {

	@GET
	@Path("/")
	public Response getHomePage() {
		String rawXml = ReadVerticle.readSource("/database/server");
		return Response.status(200).entity(rawXml).build();

	}

	@GET
	@Path("/api_info")
	public Response getTheApi() {
		return Response.status(200).entity(ServicesConstants.API_INFO).build();
	}

}
