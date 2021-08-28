package com.github.ivpal.realtime.search.web;

import com.github.ivpal.realtime.search.entity.User;
import com.github.ivpal.realtime.search.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class SearchHandler {
    private final UserService userService;

    public Mono<ServerResponse> searchUser(ServerRequest request) {
        var queryOpt = request.queryParam("q");
        if (queryOpt.isEmpty()) {
            return Mono.empty();
        }

        var query = queryOpt.get();
        var usersFlux = userService.findByQuery(query);
        return ok().body(usersFlux, User.class);
    }
}
