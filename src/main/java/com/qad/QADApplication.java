package com.qad;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
public class QADApplication implements CommandLineRunner {
	// private static final Logger LOGGER = LoggerFactory.getLogger(QADApplication.class);
	private static final Logger LOGGER = LogManager.getLogger(QADApplication.class);

    @Override
    public void run(String... args) throws Exception {
    	LOGGER.info("*************** STARTING QAD *********************");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(QADApplication.class, args);
        LOGGER.info("*************** QAD STARTED !!! *********************");
    }

}
