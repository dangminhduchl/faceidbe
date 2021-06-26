package com.Tean.ServiceCarManagement.carlist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Timestamp;

@Getter
@Setter
public class CarlistModel
{
    private String driver;
    private String license;
    private String brand;
    private int manufacturedate;
    private String cartype;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp registerdate;
    private String state;
}
