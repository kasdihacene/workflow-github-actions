package com.workflow.github.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "business")
@PropertySource(value = "classpath:business.yml", factory = YamlPropertySourceFactory.class)
@Getter
@Setter
public class BusinessConfig {

    public String name;
    public String description;
    public Rule rule;

    @Getter
    @Setter
    public static class Rule {
        public int number;
    }
}
