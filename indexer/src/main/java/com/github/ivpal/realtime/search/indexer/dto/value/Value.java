package com.github.ivpal.realtime.search.indexer.dto.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Value<T> {
    @JsonProperty("schema")
    private Schema schema;

    private Payload<T> payload;
}
