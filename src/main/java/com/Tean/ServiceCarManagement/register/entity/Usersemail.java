package com.Tean.ServiceCarManagement.register.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Usersemail
{
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;
}
