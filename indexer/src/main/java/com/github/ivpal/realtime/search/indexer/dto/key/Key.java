package com.github.ivpal.realtime.search.indexer.dto.key;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Key {
    private Schema schema;
    private Payload payload;
}
