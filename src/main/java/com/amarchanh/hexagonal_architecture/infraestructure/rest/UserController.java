package com.amarchanh.hexagonal_architecture.infraestructure.rest;

import com.amarchanh.hexagonal_architecture.application.ports.incoming.UserService;
import com.amarchanh.hexagonal_architecture.domain.model.entities.User;
import com.amarchanh.hexagonal_architecture.domain.model.mappers.UserMapper;
import com.amarchanh.hexagonal_architecture.infraestructure.rest.dto.UserRequest;
import com.amarchanh.hexagonal_architecture.infraestructure.rest.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid final UserRequest userRequest) {
        User response = this.userService.saveUser(this.userMapper.toModel(userRequest));

        return ResponseEntity.created(URI.create("/userCreated")).body(this.userMapper.toResponse(response));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable final Long id){
        final User user = this.userService.findUser(id);
        return ResponseEntity.ok(this.userMapper.toResponse(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers(@PathVariable final Long id){
        final List<User> users = this.userService.findUsers();
        return ResponseEntity.ok(this.userMapper.toResponseList(users));
    }


}
