package com.example.nbcscheduledev.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String email;
    private String userName;

    public SignUpRequestDto(String email, String userName) {
        this.email = email;
        this.userName = userName;
    }
}
