package com.github.ivpal.realtime.search.indexer.service;

import com.github.ivpal.realtime.search.indexer.domain.User;
import com.github.ivpal.realtime.search.indexer.repository.UserRepository;
import com.github.ivpal.realtime.search.indexer.value.ValueUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(ValueUser valueUser) {
        var user = new User();
        user.setId(valueUser.getId());
        user.setName(getNameFromValueUser(valueUser));
        return userRepository.save(user);
    }

    public void remove(long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> update(long id, ValueUser valueUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(getNameFromValueUser(valueUser));
                    return userRepository.save(user);
                });
    }

    private static String getNameFromValueUser(ValueUser valueUser) {
        return valueUser.getFirstName() + " " + valueUser.getLastName();
    }
}
