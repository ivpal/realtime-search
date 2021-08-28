package com.github.ivpal.realtime.search.repository;

import com.github.ivpal.realtime.search.entity.User;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveElasticsearchRepository<User, Long> {
    Flux<User> findByFirstNameOrLastName(String firstName, String lastName);
}
