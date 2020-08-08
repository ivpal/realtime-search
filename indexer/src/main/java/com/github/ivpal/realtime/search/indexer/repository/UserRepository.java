package com.github.ivpal.realtime.search.indexer.repository;

import com.github.ivpal.realtime.search.indexer.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {
}
