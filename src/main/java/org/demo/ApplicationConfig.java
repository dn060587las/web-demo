package main.java.org.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "main.java.org.demo.web")
public class ApplicationConfig {
}
