package com.example.schedulemanagementapp.service;

import com.example.schedulemanagementapp.dto.create.schedule.CreateScheduleRequest;
import com.example.schedulemanagementapp.dto.create.schedule.CreateScheduleResponse;
import com.example.schedulemanagementapp.dto.get.comment.GetCommentResponse;
import com.example.schedulemanagementapp.dto.get.schedule.GetScheduleResponse;
import com.example.schedulemanagementapp.dto.update.schedule.UpdateScheduleRequest;
import com.example.schedulemanagementapp.dto.update.schedule.UpdateScheduleResponse;
import com.example.schedulemanagementapp.entity.Comment;
import com.example.schedulemanagementapp.entity.Schedule;
import com.example.schedulemanagementapp.repository.CommentRepository;
import com.example.schedulemanagementapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 일정 생성
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request.getTitle(),request.getContent(),request.getName(), request.getPassword());
        Schedule saved = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(saved.getScheduleId(), saved.getTitle(), saved.getContent(), saved.getName(), saved.getCreatedAt(), saved.getModifiedAt());
    }

    // 일정 전체 조회
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll(String name) {
        List<Schedule> schedules;
        if(name == null ||  name.isEmpty()) {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        } else {
            schedules = scheduleRepository.findAllByNameOrderByModifiedAtDesc(name);
        }
        return schedules.stream().map(schedule -> new GetScheduleResponse(schedule.getScheduleId(), schedule.getTitle(), schedule.getContent(), schedule.getName(), schedule.getCreatedAt(), schedule.getModifiedAt())).toList();
    }

    // 일정 선택 조회
    @Transactional(readOnly = true)
    public GetScheduleResponse findOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("Schedule with id " + scheduleId + " does not exist")
        );
        List<Comment> comments = commentRepository.findAllByScheduleIdOrderByCreatedAtDesc(scheduleId);
        List<GetCommentResponse> responses = comments.stream().map(comment -> new GetCommentResponse(comment.getCommentId(), comment.getContent(), comment.getName(), comment.getCreatedAt(), comment.getModifiedAt())).toList();
        return new GetScheduleResponse(schedule.getScheduleId(), schedule.getTitle(), schedule.getContent(), schedule.getName(), schedule.getCreatedAt(), schedule.getModifiedAt(), responses);
    }

    // 일정 수정
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("Schedule with id " + scheduleId + " does not exist")
        );
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        schedule.update(request.getTitle(), request.getName());
        return new UpdateScheduleResponse(schedule.getScheduleId(), schedule.getTitle(), schedule.getContent(), schedule.getName(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }

    // 일정 삭제
    @Transactional
    public void delete(Long scheduleId) {
        boolean existence = scheduleRepository.existsById(scheduleId);
        if (!existence) {
            throw new IllegalArgumentException("Schedule with id " + scheduleId + " does not exist");
        }
        scheduleRepository.deleteById(scheduleId);
    }
}
