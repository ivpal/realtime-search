package com.github.ivpal.realtime.search.web;

import com.github.ivpal.realtime.search.client.UsersClient;
import com.github.ivpal.realtime.search.client.dto.User;
import com.github.ivpal.realtime.search.service.UserIndexService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class SearchHandler {
    private final UserIndexService userIndexService;
    private final UsersClient usersClient;

    public SearchHandler(UserIndexService userIndexService, UsersClient usersClient) {
        this.userIndexService = userIndexService;
        this.usersClient = usersClient;
    }

    public Mono<ServerResponse> searchUser(ServerRequest request) {
        var queryOpt = request.queryParam("q");
        if (queryOpt.isEmpty()) {
            return Mono.empty();
        }

        var query = queryOpt.get();
        var usersFlux = userIndexService.findByName(query)
                .flatMap(user -> usersClient.getUser(user.getId()));

        return ok().body(usersFlux, User.class);
    }
}
