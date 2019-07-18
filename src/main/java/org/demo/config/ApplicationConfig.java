package org.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.demo.web",
        "org.demo.components",
        "org.demo.dao"
})
@Import(DatabaseConfiguration.class)
public class ApplicationConfig {
}
