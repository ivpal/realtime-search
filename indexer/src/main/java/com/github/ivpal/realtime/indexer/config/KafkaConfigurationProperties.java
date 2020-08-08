package com.github.ivpal.realtime.indexer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
public class KafkaConfigurationProperties {
    private String servers;

    public KafkaConfigurationProperties() {
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }
}
