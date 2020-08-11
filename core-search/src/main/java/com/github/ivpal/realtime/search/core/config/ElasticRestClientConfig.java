package com.github.ivpal.realtime.search.core.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticRestClientConfig extends AbstractElasticsearchConfiguration {
    private final ElasticsearchConfigurationProperties properties;

    public ElasticRestClientConfig(ElasticsearchConfigurationProperties properties) {
        this.properties = properties;
    }

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        var clientConfiguration = ClientConfiguration.builder()
                .connectedTo(properties.getServers())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
