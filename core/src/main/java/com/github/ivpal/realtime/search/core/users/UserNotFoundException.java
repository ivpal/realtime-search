package com.github.ivpal.realtime.search.core.users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
        super(String.format("User with id=%d not found.", id));
    }
}
