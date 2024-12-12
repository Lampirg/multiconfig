package dev.lampirg;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SecondApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Environment environment;

    public SecondApplication(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecondApplication.class, args);
    }

    @PostConstruct
    public void init() {
        if (logger.isInfoEnabled()) {
            logger.info("Started! datasource.size {}", environment.getProperty("datasource.size"));
        }
    }
}