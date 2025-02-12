package com.example.nbcscheduledev.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String userName;        // 작성 유저명
    private final String title;           // 할일 제목
    private final String description;     // 할일 내용

    public ScheduleResponseDto(
            Long id,
            String userName,
            String title,
            String description
    ) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.description = description;
    }
}
