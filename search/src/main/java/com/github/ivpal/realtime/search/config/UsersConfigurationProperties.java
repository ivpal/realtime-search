package com.github.ivpal.realtime.search.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("users")
public class UsersConfigurationProperties {
    private String baseUrl;

    public UsersConfigurationProperties() {
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
