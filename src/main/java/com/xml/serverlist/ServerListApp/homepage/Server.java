package com.xml.serverlist.ServerListApp.homepage;

import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler;
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Server extends AbstractVerticle {

	private final Logger log = LoggerFactory.getLogger(Server.class.getName());

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new Server());
	}

	@Override
	public void start() {
		VertxResteasyDeployment deployment = new VertxResteasyDeployment();
		deployment.start();
		deployment.getRegistry().addPerInstanceResource(XmlRestService.class);
		deployment.getRegistry().addPerInstanceResource(XFormsService.class);

		// Front end server.
		vertx.createHttpServer() //
				.requestHandler(new VertxRequestHandler(vertx, deployment)) //
				.listen(8080, ar -> {
					log.info("Server started on port " + ar.result().actualPort());
				});

	}

}
