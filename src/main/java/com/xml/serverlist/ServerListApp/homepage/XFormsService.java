package com.xml.serverlist.ServerListApp.homepage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class XFormsService {
	@GET
	@Path("/xforms")
	public Response getAllServers() {
		// TODO: Read this from xml.
		String serversList = "Form1</br>Form2</br>...";
		return Response.status(200).entity(serversList).build();
	}

}
