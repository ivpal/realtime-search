package com.github.ivpal.realtime.search.service;

import com.github.ivpal.realtime.search.core.entity.User;
import com.github.ivpal.realtime.search.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UserIndexService {
    private final UserRepository userRepository;

    public UserIndexService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
