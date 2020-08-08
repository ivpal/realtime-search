package com.github.ivpal.realtime.search.indexer.core.users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
