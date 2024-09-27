package dgtic.dcn.tem.tripAPI.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Travel Expense Manager - Trip API", 
			description = "Proyecto final - Diplomado de Desarrollo "
					+ "y Despliegue de Aplicaciones Cloud Native "
					+ "Endpoints para viajes", 
			contact = @Contact(
				name = "Hugo Emilio Jara Rivera", 
				url = "https://github.com/hugoemiliojara7", 
			email = "hugoejara7@gmail.com")))
public class OpenApiConfig {

}
