package com.nexora.acc.mapper;

import com.nexora.acc.dto.UserDto;
import com.nexora.acc.entity.User;

public class UserMapper {
    public static UserDto MapsToUserDto(User user, UserDto userDto){

        userDto.setMobileNumber(user.getMobileNumber());
        userDto.setEmail(user.getEmail());
        user.setName(user.getName());
        user.setRole(user.getRole());

        return userDto;
    }

    public static User MapsToUser(User user, UserDto userDto){

        user.setMobileNumber(userDto.getMobileNumber());

        user.setEmail(userDto.getEmail());

        user.setName(userDto.getName());
        user.setRole(user.getRole());

        return user;
    }
}
