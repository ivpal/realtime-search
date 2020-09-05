package com.github.ivpal.realtime.search.service;

import com.github.ivpal.realtime.search.core.entity.User;
import com.github.ivpal.realtime.search.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class UserIndexService {
    private final UserRepository userRepository;

    public Flux<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
