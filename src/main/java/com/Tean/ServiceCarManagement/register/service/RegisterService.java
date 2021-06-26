package com.Tean.ServiceCarManagement.register.service;

import com.Tean.ServiceCarManagement.register.entity.Email;
import com.Tean.ServiceCarManagement.register.model.RegisterModel;
import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegisterService
{
    List<Users> findByUsername(String username);
    List<Email> findByEmail(String email);
    void save(RegisterModel model);

}
