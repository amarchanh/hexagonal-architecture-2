package com.amarchanh.hexagonal_architecture.application.ports.incoming;

import com.amarchanh.hexagonal_architecture.domain.model.entities.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);

    User findUser(Long id);

    List<User> findUsers();
}
