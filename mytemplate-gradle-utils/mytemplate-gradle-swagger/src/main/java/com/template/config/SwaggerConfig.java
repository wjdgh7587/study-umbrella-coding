package com.template.config;

import com.template.entity.exception.ExceptionMessage;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/***
 * Swagger Config 정의
 */
@Configuration
public class SwaggerConfig {

    @Value("${swagger.api.title}")
    private String title;

    @Value("${swagger.api.desc}")
    private String desc;

    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.url}")
    private String contactUrl;

    @Value("${swagger.contact.email}")
    private String contactEmail;

    @Value("${swagger.external.desc}")
    private String externalApiDesc;

    @Value("${swagger.external.path}")
    private String externalApiPath;

    @Bean
    public OpenAPI swaggerOpenApi(@Value("${springdoc.version}") String swaggerApiVersion){

        Info info = new Info()
                .title(title)
                .description(desc)
                .version(swaggerApiVersion)
                .contact(new Contact().name(contactName).url(contactUrl).email(contactEmail))
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));

        return new OpenAPI()
                .info(info)
                .externalDocs(new ExternalDocumentation().description(externalApiDesc).url(externalApiPath));
    }

    @Bean
    public OpenApiCustomizer openApiCustomizer(){
        return openApi -> {
            openApi.getComponents().getSchemas()
                    .putAll(ModelConverters.getInstance().read(ExceptionMessage.class));

            Schema sharedErrorSchema = new Schema();
            sharedErrorSchema.setName("Error");
            sharedErrorSchema.set$ref("#/components/schemas/Error");

            openApi.getPaths().values()
                    .forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                        ApiResponses apiResponses = operation.getResponses();
                        apiResponses
                                .addApiResponse("400", createApiResponse("BAD REQUEST", sharedErrorSchema));
                        apiResponses.addApiResponse("403", createApiResponse("FORBIDDEN", sharedErrorSchema));
                        apiResponses.addApiResponse("404", createApiResponse("NOT FOUND", sharedErrorSchema));
                        apiResponses
                                .addApiResponse("500", createApiResponse("SERVER ERROR", sharedErrorSchema));
                    }));

        };
    }

    private ApiResponse createApiResponse(String message, Schema schema){
        MediaType mediaType = new MediaType();
        mediaType.schema(schema);

        return new ApiResponse()
                .description(message)
                .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, mediaType));
    }
}
