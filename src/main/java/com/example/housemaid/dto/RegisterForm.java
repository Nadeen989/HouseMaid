package com.example.housemaid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class RegisterForm {
    private String username;
    private String password;
    private String email;
    private String role;
}
