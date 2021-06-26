package com.Tean.ServiceCarManagement.Schedule.service;

import com.Tean.ServiceCarManagement.Schedule.entity.Schedule;
import com.Tean.ServiceCarManagement.Schedule.model.ScheduleModel;
import com.Tean.ServiceCarManagement.Schedule.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService
{
    @Autowired
    private ScheduleRepo scheduleRepo;

    @Override
    public List<Schedule> findAll()
    {
        return scheduleRepo.findAll();
    }

    @Override
    public void deleteById(int id)
    {
        scheduleRepo.deleteById(id);
    }

    @Override
    public void save(ScheduleModel model)
    {
        Schedule schedule = new Schedule();
        schedule.setCarid(model.getCarid());
        schedule.setDeparture(model.getDeparture());
        schedule.setStartingtime(model.getStartingtime());
        schedule.setDestination(model.getDestination());
        schedule.setArrivingtime(model.getArrivingtime());
        schedule.setCapacity(model.getCapacity());
        scheduleRepo.save(schedule);
    }

    @Override
    public List<Schedule> findByCarid(int carid) {
        return scheduleRepo.findByCarid(carid);
    }
}
