package com.github.ivpal.realtime.search.users.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank
    @JsonProperty("first_name")
    private final String firstName;

    @NotBlank
    @JsonProperty("last_name")
    private final String lastName;

    public UserRequest(String firstName, String lastName) {
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
