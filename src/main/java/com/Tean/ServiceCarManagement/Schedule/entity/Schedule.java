package com.Tean.ServiceCarManagement.Schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Schedule
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "carid")
    private int carid;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure")
    private String departure;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "startingtime")
    private Timestamp startingtime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "arrivingtime")
    private Timestamp arrivingtime;

    @Column(name ="capacity")
    private String capacity;

}
