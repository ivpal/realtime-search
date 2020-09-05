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
public class Payload<T> {
    private T before;
    private T after;
    private Source source;
    private String op;

    @JsonProperty("ts_ms")
    private long tsMs;

    private String transaction;
}
