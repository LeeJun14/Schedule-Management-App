package com.example.schedulemanagementapp.repository;

import com.example.schedulemanagementapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
