package com.github.ivpal.realtime.search.stream;

import com.github.ivpal.realtime.search.service.UserService;
import com.github.ivpal.realtime.search.stream.value.ValueUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import com.github.ivpal.realtime.search.stream.value.Value;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UsersChangesConsumer implements Consumer<Flux<Value<ValueUser>>> {
    private final UserService userService;

    @Override
    public void accept(Flux<Value<ValueUser>> valueFlux) {
        valueFlux
            .filter(Objects::nonNull)
            .map(value -> {
                log.info("Consume event: " + value.toString());
                return value;
            })
            .flatMap(value -> {
                var payload = value.getPayload();
                return switch (payload.getOp()) {
                    case "c" -> userService.create(payload.getAfter());
                    case "d" -> userService.remove(payload.getBefore().getId());
                    case "u" -> userService.update(payload.getAfter().getId(), payload.getAfter());
                    default -> Mono.error(new IllegalStateException("Unexpected value for 'op': " + payload.getOp()));
                };
            })
            .subscribe();
    }
}
