package com.xbach.user.controllers;

import com.xbach.user.dto.request.LoginRequest;
import com.xbach.user.dto.request.UserRequest;
import com.xbach.user.dto.response.UserResponse;
import com.xbach.user.exceptions.LoginException;
import com.xbach.user.models.User;
import com.xbach.user.repositories.UserRepository;
import com.xbach.user.services.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/api/v1/users"})
@ComponentScan
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;


    @Autowired
    public AuthController(UserService userService,UserRepository userRepository) {
        this.userService = userService;
        this.userRepository= userRepository;

    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            UserResponse userResponse = userService.login(loginRequest);
            return ResponseEntity.ok(userResponse);
        } catch (LoginException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST,value = {"/registers"} )
    public ResponseEntity register(@RequestBody UserRequest registerRequest) {
        userService.register(registerRequest);
        return ResponseEntity.ok().body(registerRequest);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable  Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        try {
            UserResponse updatedUser = userService.update(userRequest, id);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

            User userResponse = userRepository.getUserById(id);

                return ResponseEntity.ok(userResponse);


    }



}
