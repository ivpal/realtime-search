package com.github.ivpal.realtime.search.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("users")
public class UsersConfigurationProperties {
    private String baseUrl;
}
