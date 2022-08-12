package com.api.notes.controllers;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.api.notes.exception.UserNotFoundException;
import com.api.notes.models.User;
import com.api.notes.repository.UserRepository;
import com.api.notes.utils.controllers.ApiUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController implements ApiUser {

    private final UserRepository userRepository; // TODO: <-- Service here..

    @Override
    public ResponseEntity<User> findById(long id, @NotNull @Valid String userAuthorization) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found for this id :: " + id));

        return ResponseEntity.ok().body(user);
    }

    @Override
    public Collection<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String id, User user) {
        return user;
    }

    @Override
    public User patchUser(String id, User user) {
        return user;
    }

    @Override
    public ResponseEntity<User> postUser(@NotNull @Valid User body, @NotNull @Valid String userAuthorization)
            throws Exception {

        return new ResponseEntity<User>(userRepository.save(body), HttpStatus.CREATED);
    }

    @Override
    public User headUser() {
       return new User();
    }

    @Override
    public long deleteUser(long id) {
        return id;
    }

}
