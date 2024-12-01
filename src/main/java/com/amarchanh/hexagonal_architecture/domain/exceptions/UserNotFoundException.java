package com.amarchanh.hexagonal_architecture.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException( Long id) {
        super("User with id " + id + " not found in database.");
    }
}
