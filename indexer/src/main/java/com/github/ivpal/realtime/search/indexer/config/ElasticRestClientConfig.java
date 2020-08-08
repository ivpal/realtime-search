package com.github.ivpal.realtime.search.indexer.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticRestClientConfig extends AbstractElasticsearchConfiguration {
    @Value("spring.elasticsearch.rest.uris")
    private String elasticUri;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        var clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticUri)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
