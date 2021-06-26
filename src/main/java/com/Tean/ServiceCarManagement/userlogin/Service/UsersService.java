package com.Tean.ServiceCarManagement.userlogin.Service;

import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import com.Tean.ServiceCarManagement.userlogin.Model.UsersModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<Users> findByUsernameAndPassword(UsersModel usersModel);

}
