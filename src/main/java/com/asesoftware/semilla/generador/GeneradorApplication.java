package com.asesoftware.semilla.generador;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication

public class GeneradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneradorApplication.class, args);
	}

}
