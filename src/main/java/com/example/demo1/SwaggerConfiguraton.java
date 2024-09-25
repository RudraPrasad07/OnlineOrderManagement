package com.example.demo1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Rudra Prasad Panda",
						email = "rudraprasadpanda007@gmail.com",
						url = "https://www.linkedin.com/in/rudra-prasad-panda-devloper"
						),
				description = "A comprehensive web solution designed to streamline eCommerce order processing, enhancing user experience and operational efficiency",
				title = "Online Order Management System",
				version = "3.0"
				
				),servers = @Server(
						description = "For Local Enviroment",
						url="http://localhost:8080"
						)
		)
public class SwaggerConfiguraton {

}
