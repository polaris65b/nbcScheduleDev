package com.example.nbcscheduledev.service;

import com.example.nbcscheduledev.dto.ScheduleRequestDto;
import com.example.nbcscheduledev.dto.ScheduleResponseDto;
import com.example.nbcscheduledev.entity.Schedule;
import com.example.nbcscheduledev.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // Create
    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(
                dto.getUserName(),
                dto.getTitle(),
                dto.getDescription()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getUserName(),
                savedSchedule.getTitle(),
                savedSchedule.getDescription()
        );
    }

    // Read

    // 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll(){
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getUserName(),
                    schedule.getTitle(),
                    schedule.getDescription()
            ));
        }
        return dtos;
    }

    // 선택 조회
    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 일정이 없습니다.")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getTitle(),
                schedule.getDescription()
        );
    }

    // Update
    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 일정이 없습니다.")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getTitle(),
                schedule.getDescription()
        );
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        if(!scheduleRepository.existsById(id)){
            throw new IllegalArgumentException("해당 id에 맞는 일정이 없습니다.");
        }
        scheduleRepository.deleteById(id);
    }
}
