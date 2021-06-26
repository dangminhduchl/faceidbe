package com.Tean.ServiceCarManagement.Schedule.repo;

import com.Tean.ServiceCarManagement.Schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScheduleRepo extends JpaRepository<Schedule, UUID>
{
    List<Schedule> findAll();
    long deleteById(int id);
    Schedule save(Schedule schedule);
    List<Schedule> findByCarid(int carid);
}
