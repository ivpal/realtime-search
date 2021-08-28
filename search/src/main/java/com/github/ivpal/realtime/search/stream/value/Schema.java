package com.github.ivpal.realtime.search.stream.value;

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
    private List<ValueField> fields;
    private boolean optional;
    private String name;
}
