package com.example.housemaid.servise;

import com.example.housemaid.dto.RegisterForm;
import com.example.housemaid.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import com.example.housemaid.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;




    public void register(User user){
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        authRepository.save(user);

        }


}


