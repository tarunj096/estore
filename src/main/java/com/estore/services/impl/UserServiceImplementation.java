package com.estore.services.impl;

import com.estore.dto.UserDto;
import com.estore.model.User;
import com.estore.repositories.UserRepository;
import com.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);
        User user = dtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return userToDto(savedUser);
    }



    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDto.getName());
        //user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User savedUser = userRepository.save(user);
        return userToDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUsers = userRepository.findAll();
        List<UserDto> userDtos = allUsers.stream().map(user -> userToDto(user)).collect(Collectors.toList());
//        List<UserDto> userDtos = null;
//        for(User user:allUsers){
//            userDtos.add(userToDto(user));
//        }
        return userDtos;
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        return userToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        //userRepository.find
        return null;
    }

    private UserDto userToDto(User savedUser) {
        UserDto userDto = UserDto.builder()
                .userId(savedUser.getUserId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .about(savedUser.getAbout())
                .build();
        return userDto;
    }

    private User dtoToUser(UserDto userDto) {
        User user = User.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .about(userDto.getAbout())
.build();
        return user;
    }
}
