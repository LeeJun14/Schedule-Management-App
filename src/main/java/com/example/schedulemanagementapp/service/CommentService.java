package com.example.schedulemanagementapp.service;

import com.example.schedulemanagementapp.dto.create.comment.CreateCommentRequest;
import com.example.schedulemanagementapp.dto.create.comment.CreateCommentResponse;
import com.example.schedulemanagementapp.entity.Comment;
import com.example.schedulemanagementapp.repository.CommentRepository;
import com.example.schedulemanagementapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    private final int maxComments = 10;

    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request) {
        if(!scheduleRepository.existsById(scheduleId)) {
            throw new IllegalArgumentException("Invalid schedule id: " + scheduleId);
        }
        long commentCount = commentRepository.countByScheduleId(scheduleId);
        if(commentCount >= maxComments) {
            throw new IllegalArgumentException("Too many comments");
        }
        Comment comment = new Comment(request.getContent(),request.getName(), request.getPassword());
        comment.setScheduleId(scheduleId);
        Comment saved = commentRepository.save(comment);
        return new CreateCommentResponse(saved.getCommentId(), saved.getScheduleId(), saved.getContent(), saved.getName(), saved.getCreatedAt(), saved.getModifiedAt());
    }

}
