package com.heroku.examples.agentforce.action.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Agentforce Action", description = "Basic Agentforce Action example")
@RestController
class AgentActionService {

    @Operation(
        summary = "Generate a badge",
        description = "Use this action in response to requests for a Heroku badge with a name on it.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "This is the Heroku badge the user requested.",
                content = @Content(mediaType = "*/*")
            )
        }
    )
    @PostMapping("/generateBadge")
    public String generateBadge(
        @Parameter(description = "Name to be placed on the badge.", required = true)
        @RequestParam String name
    ) {
        try {
            return """
                    <img src="data:image/png;base64,%s">
                    """.formatted(BadgeCreator.createBadge("Heroku Agent Action", "Deployed by " + name));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
