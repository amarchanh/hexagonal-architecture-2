package com.amarchanh.hexagonal_architecture.infraestructure.adapters;

import com.amarchanh.hexagonal_architecture.application.ports.outgoing.UserRepository;
import com.amarchanh.hexagonal_architecture.domain.exceptions.UserNotFoundException;
import com.amarchanh.hexagonal_architecture.domain.model.entities.User;
import com.amarchanh.hexagonal_architecture.infraestructure.persistence.jpa.mappers.UserEntityMapper;
import com.amarchanh.hexagonal_architecture.infraestructure.persistence.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    private final UserEntityMapper userEntityMapper;


    @Override
    public User saveUser(User user) {
        log.info("Storing user into database...");
        final var entity = this.userEntityMapper.toEntity(user);
        return this.userEntityMapper.toModel(this.userJpaRepository.save(entity));
    }

    @Override
    public User findUser(Long id) {
        return this.userEntityMapper.toModel(this.userJpaRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public List<User> findUsers() {
        return this.userEntityMapper.toModelList(this.userJpaRepository.findAll());
    }
}
