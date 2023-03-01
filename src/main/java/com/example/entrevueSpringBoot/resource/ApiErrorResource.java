package com.example.entrevueSpringBoot.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter @Setter
public class ApiErrorResource {
    private String code;
    private String message;
    private HttpStatus status;
}
