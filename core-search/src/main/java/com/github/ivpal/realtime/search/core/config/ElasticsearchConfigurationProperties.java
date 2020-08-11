package com.github.ivpal.realtime.search.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("elasticsearch")
public class ElasticsearchConfigurationProperties {
    private String servers;

    public ElasticsearchConfigurationProperties() {
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }
}
