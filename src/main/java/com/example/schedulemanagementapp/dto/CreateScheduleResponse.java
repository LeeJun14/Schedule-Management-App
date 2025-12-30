package com.example.schedulemanagementapp.dto;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class CreateScheduleResponse {
    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String name;
    private final LocalTime createdAt;
    private final LocalTime modifiedAt;

    public CreateScheduleResponse(Long scheduleId, String title, String content, String name, LocalTime createdAt, LocalTime modifiedAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
