package com.amarchanh.hexagonal_architecture.infraestructure.persistence.jpa.repository;

import com.amarchanh.hexagonal_architecture.infraestructure.persistence.mysql.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
