package dev.lampirg;

import dev.lampirg.properties.DataSourceProperties;
import dev.lampirg.properties.PropertiesPackageMarker;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = PropertiesPackageMarker.class)
public class FirstApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private DataSourceProperties dataSourceProperties;

    public FirstApplication(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }

    @PostConstruct
    public void init() {
        if (logger.isInfoEnabled()) {
            logger.info("Started! datasource.url {}, datasource.size {}",
                    dataSourceProperties.getUrl(), dataSourceProperties.getSize());
        }
    }
}