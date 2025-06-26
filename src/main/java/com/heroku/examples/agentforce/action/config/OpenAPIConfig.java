package com.heroku.examples.agentforce.action.config;

import java.util.Map;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenApiCustomiser addCustomExtensions() {
        return openApi -> {
            openApi.getPaths().forEach((path, pathItem) -> {
                pathItem.readOperations().forEach(operation -> {
                    operation.addExtension("x-sfdc", Map.of(
                        "heroku", Map.of(
                            "authorization", Map.of(
                                "connectedApp", "BadgeServiceConnectedApp",
                                "permissionSet", "BadgeServicePermissions"
                            )
                        )
                    ));
                });
            });
        };
    }
}
