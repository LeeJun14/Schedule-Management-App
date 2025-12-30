package com.example.schedulemanagementapp.repository;

import com.example.schedulemanagementapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
