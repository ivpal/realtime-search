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
public class Source {
    private String version;
    private String connector;
    private String name;

    @JsonProperty("ts_ns")
    private String tsMs;

    private String snapshot;
    private String db;
    private String schema;
    private String table;
    private String txId;
    private String lsn;
    private String xmin;
}