package com.productuserapi.productUser;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Products API", version = "1.0", description = "Products API documentation v1.0"))
@EnableJpaAuditing
public class ProductUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductUserApplication.class, args);
	}

}