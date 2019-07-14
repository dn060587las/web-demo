package org.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.demo.web", "org.demo.components"})
@Import(DatabaseConfiguration.class)
public class ApplicationConfig {
}
