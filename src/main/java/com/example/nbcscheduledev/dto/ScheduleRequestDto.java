package com.example.nbcscheduledev.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String userName;
    private String title;
    private String description;

    public ScheduleRequestDto(
            String userName,
            String title,
            String description
    ) {
        this.userName = userName;
        this.title = title;
        this.description = description;
    }
}
