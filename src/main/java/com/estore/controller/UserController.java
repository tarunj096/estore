package com.estore.controller;

import com.estore.dto.ApiMessage;
import com.estore.dto.UserDto;
import com.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //create
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    //update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String userId, @RequestBody UserDto userDto){
        UserDto user = userService.updateUser(userDto,userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //delete

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiMessage> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        ApiMessage message = ApiMessage.builder().message("User deleted").error(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //getall

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    //getbyid

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    //getbyemail
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
}
