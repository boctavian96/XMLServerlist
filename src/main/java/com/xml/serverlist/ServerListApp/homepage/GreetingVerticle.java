package com.xml.serverlist.ServerListApp.homepage;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class GreetingVerticle extends AbstractVerticle {
	

	@Override
	public void start() {
		Router router = Router.router(vertx);
		Route messageRoute = router.get("/api/message");
		messageRoute.handler(rc -> {
			rc.response().end("Hello from Vert.x");
		});
		
		router.get().handler(StaticHandler.create());
		
		vertx.createHttpServer() //
		.requestHandler(router) //
		.listen(8080);
	}
	
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new GreetingVerticle());
	}
}
