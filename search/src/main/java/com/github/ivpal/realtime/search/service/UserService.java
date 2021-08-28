package com.github.ivpal.realtime.search.service;

import com.github.ivpal.realtime.search.entity.User;
import com.github.ivpal.realtime.search.repository.UserRepository;
import com.github.ivpal.realtime.search.stream.value.ValueUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<User> create(ValueUser valueUser) {
        var user = new User();
        user.setId(valueUser.getId());
        user.setFirstName(valueUser.getFirstName());
        user.setLastName(valueUser.getLastName());
        return userRepository.save(user);
    }

    public Mono<Void> remove(long id) {
        return userRepository.deleteById(id);
    }

    public Mono<User> update(long id, ValueUser valueUser) {
        return userRepository.findById(id)
            .flatMap(user -> {
                user.setFirstName(valueUser.getFirstName());
                user.setLastName(valueUser.getLastName());
                return userRepository.save(user);
            });
    }

    public Flux<User> findByQuery(String query) {
        return userRepository.findByFirstNameOrLastName(query, query);
    }
}
