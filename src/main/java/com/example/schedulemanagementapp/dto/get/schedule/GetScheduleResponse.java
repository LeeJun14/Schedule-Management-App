package com.example.schedulemanagementapp.dto.get.schedule;

import com.example.schedulemanagementapp.dto.get.comment.GetCommentResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"scheduleId", "title", "content", "name", "createdAt", "modifiedAt", "comments"})
public class GetScheduleResponse {
    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final List<GetCommentResponse> comments;

    // 전체 조회
    public GetScheduleResponse(Long scheduleId, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = null;
    }

    // 상세 조회
    public GetScheduleResponse(Long scheduleId, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt, List<GetCommentResponse> comments) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = comments;
    }
}
