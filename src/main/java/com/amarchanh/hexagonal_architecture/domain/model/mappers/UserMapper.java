package com.amarchanh.hexagonal_architecture.domain.model.mappers;

import com.amarchanh.hexagonal_architecture.domain.model.entities.User;
import com.amarchanh.hexagonal_architecture.infraestructure.rest.dto.UserRequest;
import com.amarchanh.hexagonal_architecture.infraestructure.rest.dto.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User toModel(UserRequest request);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> userList);
}
