package com.github.ivpal.realtime.search.indexer.service;

import com.github.ivpal.realtime.search.indexer.domain.User;
import com.github.ivpal.realtime.search.indexer.repository.UserRepository;
import com.github.ivpal.realtime.search.indexer.value.ValueUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addToIndex(ValueUser valueUser) {
        var user = new User();
        user.setId(valueUser.getId());
        user.setName(valueUser.getFirstName() + " " + valueUser.getLastName());
        userRepository.save(user);
    }

    public void remove(long id) {
        userRepository.deleteById(id);
    }
}
