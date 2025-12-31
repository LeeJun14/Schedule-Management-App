package com.example.schedulemanagementapp.controller;

import com.example.schedulemanagementapp.dto.create.comment.CreateCommentRequest;
import com.example.schedulemanagementapp.dto.create.comment.CreateCommentResponse;
import com.example.schedulemanagementapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    // 댓글 생성
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> CreateComment(@PathVariable Long scheduleId, @RequestBody CreateCommentRequest request) {
        CreateCommentResponse comment = commentService.save(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
}
