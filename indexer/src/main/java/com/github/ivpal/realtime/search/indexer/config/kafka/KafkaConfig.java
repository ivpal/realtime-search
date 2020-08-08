package com.github.ivpal.realtime.search.indexer.config.kafka;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KafkaConfigurationProperties.class)
public class KafkaConfig {
}
