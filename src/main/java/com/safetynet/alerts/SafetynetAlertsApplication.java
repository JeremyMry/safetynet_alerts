package com.safetynet.alerts;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.util.JSONReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SafetynetAlertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetynetAlertsApplication.class, args);
	}

	@Bean
	public DataContainer loadModel() {
		JSONReaderUtil jsonReaderUtil = new JSONReaderUtil();
		return jsonReaderUtil.readJSON();
	}

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

	@Bean
	public Logger logger() { return LogManager.getRootLogger(); }
}
