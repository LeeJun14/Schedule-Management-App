package com.example.schedulemanagementapp.dto.create.schedule;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    private String title;
    private String content;
    private String name;
    private String password;
}
