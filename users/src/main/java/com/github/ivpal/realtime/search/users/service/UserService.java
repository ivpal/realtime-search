package com.github.ivpal.realtime.search.users.service;

import com.github.ivpal.realtime.search.users.entity.User;
import com.github.ivpal.realtime.search.users.repository.UserRepository;
import com.github.ivpal.realtime.search.users.web.dto.UserRequest;
import com.github.ivpal.realtime.search.users.web.dto.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserResponse> getById(long id) {
        return userRepository.findById(id)
                .map(user -> new UserResponse(user.getId(), user.getFirstName(), user.getLastName()));
    }

    public UserResponse create(UserRequest request) {
        var user = new User(request.getFirstName(), request.getLastName());
        user = userRepository.save(user);
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName());
    }

    public Optional<UserResponse> update(long id, UserRequest request) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(request.getFirstName());
                    user.setLastName(request.getLastName());
                    return userRepository.save(user);
                }).map(user -> new UserResponse(user.getId(), user.getFirstName(), user.getLastName()));
    }

    public Optional<User> remove(long id) {
        return userRepository.findById(id)
                .flatMap(user -> {
                    userRepository.deleteById(user.getId());
                    return Optional.of(user);
                });
    }
}
