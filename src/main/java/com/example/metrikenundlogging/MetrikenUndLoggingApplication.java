package com.example.metrikenundlogging;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@Slf4j
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

	@SneakyThrows
	@EventListener(ApplicationReadyEvent.class)
	public void logging() {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(()-> {
			while (true) {
				log.info("Simply a log event {}", LocalDateTime.now());
				Thread.sleep(1000L);
			}
		});

	}

}
