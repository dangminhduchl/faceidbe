package com.Tean.ServiceCarManagement.Schedule.service;

import com.Tean.ServiceCarManagement.Schedule.entity.Schedule;
import com.Tean.ServiceCarManagement.Schedule.model.ScheduleModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface ScheduleService
{
    List<Schedule> findAll();
    void deleteById(int id);
    void save(ScheduleModel model);
    List<Schedule> findByCarid(int carid);
}
