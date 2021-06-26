package com.Tean.ServiceCarManagement.Schedule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ScheduleModel
{
    private int carid;
    private String departure;
    private String destination;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp startingtime;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp arrivingtime;
    private String capacity;
}
