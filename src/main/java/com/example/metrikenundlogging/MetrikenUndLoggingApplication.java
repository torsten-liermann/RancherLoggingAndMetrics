package com.example.metrikenundlogging;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
		executor.submit(() -> {
			while (true) {
				log.info("Simply a log event {} - application.properties: {}", LocalDateTime.now(),
						MetrikenUndLoggingApplication.class.getResourceAsStream("/application.properties"));
				Thread.sleep(1000L);
			}
		});

	}

}
