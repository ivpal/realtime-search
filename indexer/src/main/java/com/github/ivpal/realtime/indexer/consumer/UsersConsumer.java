package com.github.ivpal.realtime.indexer.consumer;

import com.github.ivpal.realtime.indexer.value.User;
import com.github.ivpal.realtime.indexer.value.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UsersConsumer {
    private final Logger logger = LoggerFactory.getLogger(UsersConsumer.class);

    @KafkaListener(topics = "core.public.users", containerFactory = "usersKafkaListenerContainerFactory")
    public void consumeUsersChanges(Value<User> value) {
        logger.info(value.getPayload().getAfter().toString());
    }
}
