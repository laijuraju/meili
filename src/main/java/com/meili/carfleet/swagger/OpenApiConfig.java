package com.meili.carfleet.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LAIJU
 */
@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI awesomeAPI() {
		return new OpenAPI()
				.info(new Info().title("Car fleet APIs").description("This API shows the car fleet data").version("1.0")
						.summary("When the endpoint is activated, the vehicle fleet data should be"
								+ " loaded, and it should provide a single, consistent response format.")
						.license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0")))
				.externalDocs(new ExternalDocumentation().description("Laiju, ****@gmail.com").url("Meili.ie"));
	}
}
