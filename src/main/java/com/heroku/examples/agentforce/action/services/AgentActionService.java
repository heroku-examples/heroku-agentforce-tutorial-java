package com.heroku.examples.agentforce.action.services;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@Tag(name = "Agentforce Action", description = "Basic Agentforce Action example")
@RestController
class AgentActionService {

    @PostMapping("/process")
    public AgentResponse process(@RequestBody AgentRequest request) {
        AgentResponse response = new AgentResponse();
        try {
            response.message = """
                    <img src="data:image/png;base64,%s">
                    """.formatted(BadgeCreator.createBadge("Heroku Agent Action", "Deployed by " + request.name));
            Files.writeString(Path.of("./debug.html"), "<body style=\"background: black\">" + response.message + "</body>");
            return response;
        } catch (Exception e) {
            response.message = e.getMessage();
            return response;
        }
    }

    public static class AgentRequest {
        @Schema(example = "Neo")
        public String name;
    }

    public static class AgentResponse {
        public String message;
    }
}