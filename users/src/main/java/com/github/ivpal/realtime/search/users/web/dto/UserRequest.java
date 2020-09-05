package com.github.ivpal.realtime.search.users.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class UserRequest {
    @NotBlank
    @JsonProperty("first_name")
     String firstName;

    @NotBlank
    @JsonProperty("last_name")
    String lastName;
}
