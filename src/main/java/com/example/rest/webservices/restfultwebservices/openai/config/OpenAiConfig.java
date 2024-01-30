package com.example.rest.webservices.restfultwebservices.openai.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Custom API Documentation",
				description = "Doing CRUD operation",
				summary = "this projects prefoms all CRUD including path variable",
				termsOfService = "T&C",
				contact = @Contact(
						name = "Shiva",
						email = "shuklashivanshu79@gmail.com"
				),
				license = @License(
						name = "Your license number...."
				),
				version = "v1"
				
				)
		)


public class OpenAiConfig {

}
