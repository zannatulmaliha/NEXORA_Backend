package com.nexora.acc.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponseDto {
    private String token;
    private String message;
}
