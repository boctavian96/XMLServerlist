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
		Route helloRoute = router.get("/api/message");
		helloRoute.handler(rc -> {
			rc.response().end("Hello from Vert.x");
		});
		
		Route copitulinaRoute = router.get("/api/copitulina");
		copitulinaRoute.handler(rc -> {
			rc.response().end("<h1>Adelina ii kopitulina</h1>");
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
