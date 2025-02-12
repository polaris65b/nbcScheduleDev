package com.example.nbcscheduledev.repository;

import com.example.nbcscheduledev.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
