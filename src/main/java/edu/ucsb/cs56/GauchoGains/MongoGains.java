package edu.ucsb.cs56.GauchoGains;

import edu.ucsb.cs56.GauchoGains.GainsDatabase;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class MongoGains {

	public static void main(String[] args) {
		GainsDatabase db = new GainsDatabase();
		port(getHerokuAssignedPort());

		Map map = new HashMap();
		get("/", (rq, rs) -> new ModelAndView(map, "signupform.mustache"), new MustacheTemplateEngine());
		post("/signup", (rq,rs) -> db.signUp(rq));
		post("/login", (rq,rs) -> db.logIn(rq));

	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
	}

}
