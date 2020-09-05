package com.github.ivpal.realtime.search.users.web;

import com.github.ivpal.realtime.search.users.service.UserService;
import com.github.ivpal.realtime.search.users.error.UserNotFoundException;
import com.github.ivpal.realtime.search.users.web.dto.UserRequest;
import com.github.ivpal.realtime.search.users.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable long id) {
        return userService.getById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody @Validated UserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/{id}")
    public UserResponse create(@PathVariable long id, @RequestBody @Validated UserRequest request) {
        return userService.update(id, request)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable long id) {
        userService.remove(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
