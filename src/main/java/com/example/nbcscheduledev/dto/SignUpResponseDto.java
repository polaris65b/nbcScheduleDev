package com.example.nbcscheduledev.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {
    private final Long id;
    private final String userName;
    private final String email;

    public SignUpResponseDto(
            Long id,
            String userName,
            String email
    ) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
