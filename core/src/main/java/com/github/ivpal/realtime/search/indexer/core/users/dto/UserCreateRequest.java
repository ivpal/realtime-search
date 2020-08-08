package com.github.ivpal.realtime.search.indexer.core.users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateRequest {
    @JsonProperty("first_name")
    private final String firstName;

    @JsonProperty("last_name")
    private final String lastName;

    public UserCreateRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
