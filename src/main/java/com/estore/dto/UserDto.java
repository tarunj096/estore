package com.estore.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String  userId;

    @Size(min = 3,max = 20,message = "Name must be between 3 and 20 characters")
    private String name;

    @Email(message = "Email should be valid")
    private String email;


    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "About is required")
    private String about;
}
