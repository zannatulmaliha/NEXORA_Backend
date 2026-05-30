package com.nexora.acc.controller;


import com.nexora.acc.dto.AuthResponseDto;
import com.nexora.acc.dto.LoginRequestDto;
import com.nexora.acc.dto.RegisterRequestDto;
import com.nexora.acc.service.iAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final iAuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDto dto){
        return authService.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto dto){
        return authService.login(dto);
    }

}
