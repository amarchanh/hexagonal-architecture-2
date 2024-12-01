package com.amarchanh.hexagonal_architecture.application.services;

import com.amarchanh.hexagonal_architecture.application.ports.incoming.UserService;
import com.amarchanh.hexagonal_architecture.application.ports.outgoing.UserRepository;
import com.amarchanh.hexagonal_architecture.domain.model.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return this.userRepository.saveUser(user);
    }

    @Override
    public User findUser(Long id) {
        return this.userRepository.findUser(id);
    }

    @Override
    public List<User> findUsers() {
        return this.userRepository.findUsers();
    }
}
