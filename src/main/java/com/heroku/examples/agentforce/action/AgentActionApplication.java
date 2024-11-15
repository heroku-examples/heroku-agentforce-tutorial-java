package com.heroku.examples.agentforce.action;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Agentforce Action",
                version = "1.0.0",
                description = "Basic example of an Agentforce Action"
        )
)
public class AgentActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentActionApplication.class, args);
    }

}