package com.example.housemaid.config;

import com.example.housemaid.model.User;
import com.example.housemaid.repository.AuthRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


    @Service
    @RequiredArgsConstructor
    public class MyUserDetailsService implements UserDetailsService {


        private final AuthRepository authRepository;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User myuser=authRepository.findUserByUsername(username);

            if(myuser==null){
                throw new UsernameNotFoundException("Wrong username or password");
            }

            return myuser;
        }
}
