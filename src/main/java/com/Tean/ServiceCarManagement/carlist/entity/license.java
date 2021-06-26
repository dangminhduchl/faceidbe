package com.Tean.ServiceCarManagement.carlist.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class license
{
    @Id
    @Column(name = "license")
    private String license;
}
