package com.github.ivpal.realtime.search.core.config;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
@RequiredArgsConstructor
public class ElasticRestClientConfig extends AbstractElasticsearchConfiguration {
    private final ElasticsearchConfigurationProperties properties;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        var clientConfiguration = ClientConfiguration.builder()
                .connectedTo(properties.getServers())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
