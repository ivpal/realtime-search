package com.github.ivpal.realtime.search.core.users;

import com.github.ivpal.realtime.search.core.users.dto.UserCreateRequest;
import com.github.ivpal.realtime.search.core.users.dto.UserResponse;
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

    public UserResponse create(UserCreateRequest request) {
        var user = new User(request.getFirstName(), request.getLastName());
        user = userRepository.save(user);
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName());
    }
}
