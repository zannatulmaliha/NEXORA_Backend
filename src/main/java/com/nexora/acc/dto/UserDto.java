package com.nexora.acc.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long user_id;
    private String name;
    private String email;
    private String role;
    private String mobileNumber;
}
