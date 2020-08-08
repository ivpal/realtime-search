package com.github.ivpal.realtime.search.indexer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("kafkaErrorHandler")
public class KafkaErrorHandler implements KafkaListenerErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerErrorHandler.class);

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        LOGGER.error(exception.getMessage());
        return null;
    }
}
