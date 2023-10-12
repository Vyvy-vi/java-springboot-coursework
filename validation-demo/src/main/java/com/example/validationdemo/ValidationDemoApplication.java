package com.example.validationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @Builder - annotation for constructing domain / model class with
// partial arguments without having to use many getters and setters
// (this is provided by omBok)

// We should never expose our domain classes in the Controller
// use DTOs instead.

// Validation (java.validation.constraints)
// @NotNull
// @NotBlank - neither null nor empty
// @NotEmpty
// @Valid - annotation added in argument of Controller

// Jericho functions

@SpringBootApplication
public class ValidationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationDemoApplication.class, args);
	}

}
