package com.Tean.ServiceCarManagement.userlogin.Service;

import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import com.Tean.ServiceCarManagement.userlogin.Model.UsersModel;
import com.Tean.ServiceCarManagement.userlogin.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService
{
    @Autowired
    private UsersRepo usersRepo;
    @Override
    public List<Users> findByUsernameAndPassword(UsersModel usersModel)
    {
        List<Users> list = usersRepo.findByUsernameAndPassword(usersModel.getUsername(),usersModel.getPassword());
        return list;
    }
}
