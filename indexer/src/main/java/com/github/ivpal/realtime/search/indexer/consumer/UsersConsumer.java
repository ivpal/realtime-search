package com.github.ivpal.realtime.search.indexer.consumer;

import com.github.ivpal.realtime.search.indexer.value.Value;
import com.github.ivpal.realtime.search.indexer.value.ValueUser;
import com.github.ivpal.realtime.search.indexer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UsersConsumer {
    private final Logger logger = LoggerFactory.getLogger(UsersConsumer.class);

    private final UserService userService;

    public UsersConsumer(UserService userService) {
        this.userService = userService;
    }

    @KafkaListener(
            topics = "core.public.users",
            containerFactory = "usersKafkaListenerContainerFactory",
            errorHandler = "kafkaErrorHandler"
    )
    public void consumeUsersChanges(Value<ValueUser> value) {
        logger.info("Consume event: " + value);
        if (value == null) return;

        var payload = value.getPayload();
        switch (payload.getOp()) {
            case "c" -> userService.create(payload.getAfter());
            case "d" -> userService.remove(payload.getBefore().getId());
            case "u" -> userService.update(payload.getAfter().getId(), payload.getAfter());
        }
    }
}
