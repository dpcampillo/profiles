package com.sophos.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sophos.dev.validator.ValidatorConverter;

@SpringBootApplication
public class DevelopSslApplication {

	@Bean
	public ValidatorConverter validatorConverter() {
		return new ValidatorConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(DevelopSslApplication.class, args);
	}

}
