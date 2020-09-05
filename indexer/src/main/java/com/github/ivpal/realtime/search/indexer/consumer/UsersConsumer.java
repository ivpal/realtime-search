package com.github.ivpal.realtime.search.indexer.consumer;

import com.github.ivpal.realtime.search.indexer.service.UserService;
import com.github.ivpal.realtime.search.indexer.dto.value.Value;
import com.github.ivpal.realtime.search.indexer.dto.value.ValueUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UsersConsumer {
    private final UserService userService;

    @KafkaListener(
            topics = "core.public.users",
            containerFactory = "usersKafkaListenerContainerFactory",
            errorHandler = "kafkaErrorHandler"
    )
    public void consumeUsersChanges(Value<ValueUser> value) {
        log.info("Consume event: " + value);
        if (value == null) return;

        var payload = value.getPayload();
        switch (payload.getOp()) {
            case "c" -> userService.create(payload.getAfter());
            case "d" -> userService.remove(payload.getBefore().getId());
            case "u" -> userService.update(payload.getAfter().getId(), payload.getAfter());
        }
    }
}
