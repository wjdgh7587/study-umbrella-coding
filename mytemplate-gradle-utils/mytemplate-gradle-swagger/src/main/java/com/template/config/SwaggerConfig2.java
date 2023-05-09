//package com.template.config;
//
//import com.template.entity.exception.ExceptionMessage;
//import io.swagger.v3.core.converter.ModelConverters;
//import io.swagger.v3.oas.annotations.ExternalDocumentation;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.info.License;
//import io.swagger.v3.oas.models.media.Content;
//import io.swagger.v3.oas.models.media.MediaType;
//import io.swagger.v3.oas.models.media.Schema;
//import io.swagger.v3.oas.models.responses.ApiResponse;
//import io.swagger.v3.oas.models.responses.ApiResponses;
//import org.springdoc.core.customizers.OpenApiCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//// yml 동적 사용으로 값 채움
//@OpenAPIDefinition(
//        info = @Info(
//                title = "${swagger.api.title}",
//                description = "${swagger.api.desc}",
//                version = "${swagger.api.version}",
//                license = @License(
//                        name = "${swagger.license.name}"
//                        , url = "${swagger.license.url}"),
//                contact = @Contact(
//                        name = "${swagger.contact.name}"
//                        , email = "${swagger.contact.email}"
//                        , url = "${swagger.contact.url}")
//        ),
//        externalDocs = @ExternalDocumentation(
//                description = "${swagger.external.desc}", url = "${swagger.external.path}"
//        )
//)
//@Configuration
//public class SwaggerConfig2 {
//
//    @Bean
//    public OpenApiCustomizer openApiCustomizer() {
//
//        return openApi -> {
//            openApi.getComponents().getSchemas()
//                    .putAll(ModelConverters.getInstance().read(ExceptionMessage.class));
//
//            Schema sharedErrorSchema = new Schema();
//            sharedErrorSchema.setName("Error");
//            sharedErrorSchema.set$ref("#/components/schemas/Error");
//
//            openApi.getPaths().values()
//                    .forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
//                        ApiResponses apiResponses = operation.getResponses();
//                        apiResponses
//                                .addApiResponse("400", createApiResponse("BAD REQUEST", sharedErrorSchema));
//                        apiResponses.addApiResponse("403", createApiResponse("FORBIDDEN", sharedErrorSchema));
//                        apiResponses.addApiResponse("404", createApiResponse("NOT FOUND", sharedErrorSchema));
//                        apiResponses
//                                .addApiResponse("500", createApiResponse("SERVER ERROR", sharedErrorSchema));
//                    }));
//
//        };
//
//    }
//
//    private ApiResponse createApiResponse(String message, Schema schema){
//        MediaType mediaType = new MediaType();
//        mediaType.schema(schema);
//
//        return new ApiResponse()
//                .description(message)
//                .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, mediaType));
//    }
//
//}
//
///****
// * Swagger 정의
// *
// * - 성능 측면에서 @Bean 주입 메소드 정의나, @OpenApiDefinition 에서는 성능 차이가 없다.
// * 왜냐하면 Swagger 문서는 애플리케이션의 실행 시점에만 필요하기 때문이다.
// *
// * 유지보수 측면에서는 두 가지 방법 중 어떤 것이 더 우수한지는 상황에 따라 다름
// * @Bean 주입을 통한 방법은 코드 가독성과 유지보수성 향상이 가능함 또한 유연성 부분도 높음
// *
// * 반면에 @OpenAPIDefinition 은 Swagger 설정을 클래스로 한꺼번에 관리할 수 있음으로, 일관성을 유지할 수 있음
// * 또한 세밀한 Swagger 설정을 구성할 수 있음
// *
// * 따라서 아래와 같이 사용하고자함
// * Swagger 에 대한 기본적인 정의는 @OpenAPIDefinition 을 활용하여 구성하하고 기타 세밀한 부분은 @Bean주입을 통해서 별도로 관리하고자함
// *
// *
// */
