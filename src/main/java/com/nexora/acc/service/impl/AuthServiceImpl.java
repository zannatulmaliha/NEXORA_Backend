package com.nexora.acc.service.impl;

import com.nexora.acc.dto.AuthResponseDto;
import com.nexora.acc.dto.LoginRequestDto;
import com.nexora.acc.dto.RegisterRequestDto;
import com.nexora.acc.entity.User;
import com.nexora.acc.mapper.UserMapper;
import com.nexora.acc.repository.UserRepository;
import com.nexora.acc.service.iAuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements iAuthService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequestDto dto){

        User user=new User();

        Optional<User>option1=userRepository.findByEmail(dto.getEmail());

        Optional<User>option2=userRepository.findByMobileNumber(dto.getMobileNumber());

        if(option1.isPresent() || option2.isPresent()){
            throw new RuntimeException("User already exists");
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setMobileNumber(dto.getMobileNumber());
        user.setRole("BUYER");



        userRepository.save(user);

        return "User registered succesfully";
    }

    public AuthResponseDto login(LoginRequestDto dto){

        User user=userRepository.findByEmail(dto.getEmail()).orElseThrow(()->new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassoword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }


        String token= "JWT_TOKEN_HERE";

        return new AuthResponseDto(
                token,
                "Login successful"
        );
    }

}
