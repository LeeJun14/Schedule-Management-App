package com.example.schedulemanagementapp.dto.create.comment;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private String content;
    private String name;
    private String password;
}
