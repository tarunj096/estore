package com.estore.dto;

import lombok.*;
import org.springframework.http.HttpStatus;


import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiMessage {
    private String message;
    private boolean error;
    private HttpStatus status;
}
