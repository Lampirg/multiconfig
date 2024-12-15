package dev.lampirg.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "datasource", ignoreUnknownFields = false)
public class DataSourceProperties {

    private String url;
    private int size;

    @ConstructorBinding
    public DataSourceProperties(String url, int size) {
        this.url = url;
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public int getSize() {
        return size;
    }
}
