package com.amarchanh.hexagonal_architecture.infraestructure.persistence.jpa.mappers;

import com.amarchanh.hexagonal_architecture.domain.model.entities.User;
import com.amarchanh.hexagonal_architecture.infraestructure.persistence.mysql.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toModel(UserEntity entity);

    List<User> toModelList(List<UserEntity> entityList);
}
