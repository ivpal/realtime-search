package com.github.ivpal.realtime.search.core.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("elasticsearch")
public class ElasticsearchConfigurationProperties {
    private String servers;
}
