package com.example.schedulemanagementapp.repository;

import com.example.schedulemanagementapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 전체 조회 시 DB의 Entity를 modifiedAt을 기준으로 내림차순 정렬
    List<Schedule> findAllByOrderByModifiedAtDesc();
}
