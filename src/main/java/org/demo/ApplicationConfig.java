package org.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.demo.web", "org.demo.components"})
public class ApplicationConfig {
}
