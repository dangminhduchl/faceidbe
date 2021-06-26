package com.Tean.ServiceCarManagement.userlogin.Controller;

import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import com.Tean.ServiceCarManagement.userlogin.Model.AuthModel;
import com.Tean.ServiceCarManagement.userlogin.Model.UsersModel;
import com.Tean.ServiceCarManagement.userlogin.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UsersAPIController
{
    @Autowired
    private UsersService usersService;

    @PostMapping("/users/login")
    public ResponseEntity<?> checkLogin(Principal principal, @RequestBody UsersModel usersModel)
    {
        AuthModel response = new AuthModel();
        List<Users> list = usersService.findByUsernameAndPassword(usersModel);
        if(list.size()==0)
        {
            response.setStatus(401);
            response.setMessage("Incorrect username or password");
        }
        else
        {
            response.setToken("1");
            response.setStatus(0);
            response.setUser(usersModel.getUsername());
        }
        return ResponseEntity.ok().body(response);
    }
}
