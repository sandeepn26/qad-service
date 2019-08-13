package com.qad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.qad.*" })
public class QADApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(QADApplication.class);

    @Override
    public void run(String... args) throws Exception {
    	LOGGER.info("*************** STARTING QAD *********************");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(QADApplication.class, args);
        LOGGER.info("*************** QAD STARTED !!! *********************");
    }

}