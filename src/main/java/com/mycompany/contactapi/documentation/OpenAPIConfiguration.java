package com.mycompany.contactapi.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info (
                contact = @Contact(
                        name = "Write To",
                        email = "writetoamrit@gmail.com",
                        url = "https://writetoamrit.io"
                ),
                description = "OpenApi Documentation for Contact Management System",
                title = "Contact Management System",
                version = "1.0",
                license = @License(
                        name = "Under XXX License",
                        url = "https://contact-license.com"
                ),
                termsOfService = "Contact Terms of Service"
        ),
        servers = {
                @Server(
                        description = "Local Env",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "QA Env",
                        url = "http://qa:8080"
                ),
                @Server(
                        description = "Prod Env",
                        url = "http://prod:8080"
                )
        }
)
public class OpenAPIConfiguration {

}