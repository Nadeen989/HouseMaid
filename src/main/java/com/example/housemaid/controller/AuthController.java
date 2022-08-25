package com.example.housemaid.controller;

import com.example.housemaid.dto.ApiResponse;
import com.example.housemaid.dto.RegisterForm;
import com.example.housemaid.model.User;
import com.example.housemaid.repository.AuthRepository;
import com.example.housemaid.servise.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthRepository authRepository;
    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user) {

        authService.register(user);
        return ResponseEntity.status(201).body("New User registered !");
    }

    @PostMapping("/login")
    public ResponseEntity login(){

        return ResponseEntity.status(200).body(new ApiResponse("Welcome back !",200));
    }


}
