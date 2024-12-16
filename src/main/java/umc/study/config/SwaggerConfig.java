package umc.study.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Springdoc OpenAPI 사용하여 API 문서를 자동 생성. Swagger UI 보여주기 위한 설정 클래스
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("UMC Study API")
                        .version("1.0")
                        .description("UMC Study 프로젝트의 REST API 문서"));
    }
}
