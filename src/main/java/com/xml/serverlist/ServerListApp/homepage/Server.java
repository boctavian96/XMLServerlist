package com.xml.serverlist.ServerListApp.homepage;

import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler;
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class GreetingServer extends AbstractVerticle {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new GreetingServer());
	}

	@Override
	public void start() {
		VertxResteasyDeployment deployment = new VertxResteasyDeployment();
		deployment.start();
		deployment.getRegistry().addPerInstanceResource(GreetingRestService.class);

		// Front end server.
		vertx.createHttpServer() //
				.requestHandler(new VertxRequestHandler(vertx, deployment)) //
				.listen(8080, ar -> {
					System.out.println("Server started on port " + ar.result().actualPort());
				});

	}

}
