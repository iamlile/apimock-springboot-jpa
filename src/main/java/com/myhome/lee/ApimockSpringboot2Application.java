package com.myhome.lee;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApimockSpringboot2Application {
	private static 	Logger logger = Logger.getLogger(ApimockSpringboot2Application.class);


	public static void main(String[] args) {
		SpringApplication.run(ApimockSpringboot2Application.class, args);
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");

	}
}
