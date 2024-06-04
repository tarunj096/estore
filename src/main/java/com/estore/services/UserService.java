package com.estore.services;

import com.estore.dto.UserDto;

import java.util.List;

public interface UserService {
    //create user
    UserDto createUser(UserDto userDto);
    //delete user
    void deleteUser(String userId);
    //update user
    UserDto updateUser(UserDto userDto, String userId);

    //get all user

    List<UserDto> getAllUser();

    //get user by id
    UserDto getUserById(String userId);

    //get user by email
    UserDto getUserByEmail(String email);
}
