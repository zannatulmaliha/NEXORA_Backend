package com.nexora.acc.service;

import com.nexora.acc.dto.AuthResponseDto;
import com.nexora.acc.dto.LoginRequestDto;
import com.nexora.acc.dto.RegisterRequestDto;
import com.nexora.acc.dto.UserDto;

public interface iAuthService {
    String register(RegisterRequestDto dto);
    AuthResponseDto login(LoginRequestDto dto);

    boolean updateUser(UserDto userDto);
    boolean deleteUser(String mobileNumber);

}

