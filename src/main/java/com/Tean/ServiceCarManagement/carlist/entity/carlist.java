package com.Tean.ServiceCarManagement.carlist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class carlist
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "driver")
    private String driver;

    @Column(name = "license")
    private String license;

    @Column(name = "brand")
    private String brand;

    @Column(name = "manufacturedate")
    private  int manufacturedate;

    @Column(name = "cartype")
    private String cartype;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "registerdate")
    private Timestamp registerdate;

    @Column(name = "state")
    private String state;
}
