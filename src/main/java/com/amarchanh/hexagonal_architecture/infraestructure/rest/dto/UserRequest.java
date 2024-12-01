package com.amarchanh.hexagonal_architecture.infraestructure.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String firstName;

    private String lastName;
}
