package com.example.metrikenundlogging;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MetrikenUndLoggingApplication {

	public static void main(String[] args) {
		var applicationBuilder = new SpringApplicationBuilder(MetrikenUndLoggingApplication.class)
				.web(WebApplicationType.SERVLET);
		if (useJsonLogging()) {
			if (useJsonLogging()) {
				applicationBuilder.profiles("json-logging");
			}
		}
		applicationBuilder.run(args);
	}

	private static boolean useJsonLogging() {
		return Boolean.parseBoolean(System.getenv("JSON_LOGGING"));
	}

}
