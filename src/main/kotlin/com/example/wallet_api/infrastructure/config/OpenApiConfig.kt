package com.example.wallet_api.infrastructure.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig{
    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI().info(
            Info().title("Wallet API")
                .version("v1.0.0")
                .description("Wallet API is a personal financial management system focused on helping users organize and evolve their financial life progressively.")
                .license(
                    License()
                        .name("MIT License")
                        .url("https://opensource.org/licenses/MIT")
                )
        )
    }
}