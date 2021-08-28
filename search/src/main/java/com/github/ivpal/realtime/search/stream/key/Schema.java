package com.github.ivpal.realtime.search.stream.key;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Schema {
    private String type;
    private List<Field> fields;
    private boolean optional;
    private String name;
}
