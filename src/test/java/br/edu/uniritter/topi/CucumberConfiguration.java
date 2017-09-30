package br.edu.uniritter.topi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"br.edu.uniritter.*"})
@PropertySource("classpath:application.properties")
public class CucumberConfiguration {
}