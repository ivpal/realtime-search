package com.github.ivpal.realtime.search.indexer.dto.value;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ColumnField {
    private String type;
    private boolean optional;
    private String field;
}
