package com.github.ivpal.realtime.search.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class Router {
    private final SearchHandler searchHandler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route()
            .GET("/search", searchHandler::searchUser)
            .build();
    }
}
