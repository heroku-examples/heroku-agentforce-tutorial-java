package com.heroku.examples.agentforce.action.services;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Agentforce Action", description = "Basic Agentforce Action example")
@RestController
class AgentActionService {

    @PostMapping("/agentaction")
    public AgentResponse process(@RequestBody AgentRequest request) {
        AgentResponse response = new AgentResponse();
        response.message = """
            Welcome %s to the Matrix""".formatted(request.name);
        return response;
    }

    public static class AgentRequest {
        @Schema(example = "Neo")
        public String name;
    }

    public static class AgentResponse {
        public String message;
    }
}