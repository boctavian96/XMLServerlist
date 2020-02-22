package com.xml.serverlist.ServerListApp.homepage;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.xml.serverlist.ServerListApp.database.ReadVerticle;
import com.xml.serverlist.html.TableBuilder;

@Path("/")
public class HomeService {

	@GET
	@Path("/")
	public Response getHomePage() {
		List<String> rawXml = ReadVerticle.readSource("/database/server");
		TableBuilder tb = new TableBuilder();
		tb.appendCol(rawXml);
		return Response.status(200).entity(tb.buildTable()).build();

	}

	@GET
	@Path("/api_info")
	public Response getTheApi() {
		return Response.status(200).entity(ServicesConstants.API_INFO).build();
	}

}
