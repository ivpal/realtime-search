package com.github.ivpal.realtime.search.indexer.config.kafka;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("kafka")
public class KafkaConfigurationProperties {
    private String servers;
}
