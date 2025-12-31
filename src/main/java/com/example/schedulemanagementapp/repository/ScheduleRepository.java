package com.example.schedulemanagementapp.repository;

import com.example.schedulemanagementapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 전체 조회 시 DB의 Entity를 modifiedAt을 기준으로 내림차순 정렬
    List<Schedule> findAllByOrderByModifiedAtDesc();

    // 전체 조회 시 작성자명이 매개변수로 입력될 시 동일한 작성자명의 Entity를 정렬
    List<Schedule> findAllByNameOrderByModifiedAtDesc(String name);
}
