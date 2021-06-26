package com.Tean.ServiceCarManagement.register.service;

import com.Tean.ServiceCarManagement.register.entity.Email;
import com.Tean.ServiceCarManagement.register.entity.Usersemail;
import com.Tean.ServiceCarManagement.register.model.RegisterModel;
import com.Tean.ServiceCarManagement.register.repo.EmailRepo;
import com.Tean.ServiceCarManagement.register.repo.UsersRegisterRepo;
import com.Tean.ServiceCarManagement.register.repo.UsersemailRepo;
import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService
{
    @Autowired
    private UsersRegisterRepo usersRegisterRepo;
    @Autowired
    private EmailRepo emailRepo;
    @Autowired
    private UsersemailRepo usersemailRepo;
    @Override
    public List<Users> findByUsername(String username)
    {
        return usersRegisterRepo.findByUsername(username);
    }

    @Override
    public List<Email> findByEmail(String email)
    {
        return emailRepo.findByEmail(email);
    }

    @Override
    public void save(RegisterModel model)
    {
        Email email = new Email();
        email.setEmail(model.getReemail());
        emailRepo.save(email);
        Users users = new Users();
        users.setUsername(model.getReusername());
        users.setPassword(model.getRepassword());
        usersRegisterRepo.save(users);
        Usersemail usersemail = new Usersemail();
        usersemail.setUsername(model.getReusername());
        usersemail.setEmail(model.getReemail());
        usersemailRepo.save(usersemail);
    }
}
