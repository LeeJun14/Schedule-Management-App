package com.example.schedulemanagementapp.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleResponse {
    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String name;
    private final String createdAt;
    private final String modifiedAt;

    public UpdateScheduleResponse(Long scheduleId, String title, String content, String name, String createdAt, String modifiedAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
