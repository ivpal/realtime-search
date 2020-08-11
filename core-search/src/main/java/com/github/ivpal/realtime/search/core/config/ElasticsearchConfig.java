package com.github.ivpal.realtime.search.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ElasticsearchConfigurationProperties.class)
public class ElasticsearchConfig {
}
