package com.nexora.acc.controller;

import com.nexora.acc.dto.*;
import com.nexora.acc.service.iAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final iAuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterRequestDto dto){
        return authService.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto dto){
        return authService.login(dto);
    }



    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto){
        boolean updated=authService.updateUser(userDto);
        if(updated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200","Request processed successfully"));
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("500","An error occured.Please try again or contact Dev team"));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto>deleteAccount(@RequestParam String mobileNumber){
        boolean is_deleted=authService.deleteUser(mobileNumber);

        if(is_deleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200","Request processed successfully"));
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("500","An error occured.Please try again or contact Dev team"));
        }
    }

}
