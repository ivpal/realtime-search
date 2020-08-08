package com.github.ivpal.realtime.indexer.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.ivpal.realtime.indexer.key.Key;
import com.github.ivpal.realtime.indexer.value.ValueUser;
import com.github.ivpal.realtime.indexer.value.Value;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaUsersConsumerConfig {
    private final KafkaConfigurationProperties kafkaProperties;

    public KafkaUsersConsumerConfig(KafkaConfigurationProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ConsumerFactory<Key, Value<ValueUser>> usersConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "users-changes-consumer-group");

        return new DefaultKafkaConsumerFactory<>(
                props,
                new JsonDeserializer<>(Key.class),
                new JsonDeserializer<>(new TypeReference<>() {})
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Key, Value<ValueUser>> usersKafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<Key, Value<ValueUser>>();
        factory.setConsumerFactory(usersConsumerFactory());
        return factory;
    }
}
