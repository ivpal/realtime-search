package com.github.ivpal.realtime.search.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "users")
public class User {
    @Id private Long id;
    private String firstName;
    private String lastName;
}
