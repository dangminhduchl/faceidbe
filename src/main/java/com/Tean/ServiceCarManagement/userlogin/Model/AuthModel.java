package com.Tean.ServiceCarManagement.userlogin.Model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthModel
{
    private int status;
    private String token;
    private String message;
    private String user;
}
