package net.microservice.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;



@OpenAPIDefinition(
		info = @Info(
				title = "Department SERVICE REST API's",
				description = "Department Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Amit",
						email = "a.amitnandan@gmail.com",
						url="https://github.com/amitnandan"
				),
				license = @License(
						name = "Apache2.0",
						url = "https://github.com/amitnandan"

				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Department-Service Doc",
						url = "https://www.github.com/amitnandan"
			)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
