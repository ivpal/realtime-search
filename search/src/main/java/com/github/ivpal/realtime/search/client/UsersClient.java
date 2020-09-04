package com.github.ivpal.realtime.search.client;

import com.github.ivpal.realtime.search.client.dto.User;
import com.github.ivpal.realtime.search.config.UsersConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UsersClient {
    private final WebClient webClient;

    public UsersClient(UsersConfigurationProperties usersProperties) {
        webClient = WebClient.builder().baseUrl(usersProperties.getBaseUrl()).build();
    }

    public Mono<User> getUser(long id) {
        return webClient.get().uri("/{id}", id).retrieve().bodyToMono(User.class);
    }
}
