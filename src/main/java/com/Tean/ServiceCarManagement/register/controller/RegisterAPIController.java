package com.Tean.ServiceCarManagement.register.controller;

import com.Tean.ServiceCarManagement.register.entity.Email;
import com.Tean.ServiceCarManagement.register.model.AuthModel;
import com.Tean.ServiceCarManagement.register.model.RegisterModel;
import com.Tean.ServiceCarManagement.register.service.RegisterService;
import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class RegisterAPIController
{
    @Autowired
    private RegisterService registerService;

    @PostMapping("/users/register")
    public ResponseEntity<?> checkRegister(Principal pricipal, @RequestBody RegisterModel registerModel)
    {
        AuthModel res = new AuthModel();
        List<Users> listusers = registerService.findByUsername(registerModel.getReusername());
        List<Email> listemail = registerService.findByEmail(registerModel.getReemail());
        if(listusers.size()==0 && listemail.size()!=0)
        {
            res.setStatus(402);
            res.setMessage("Email is already used");
            return ResponseEntity.ok().body(res);
        }
        else    if(listusers.size()!=0 && listemail.size()==0)
        {
            res.setStatus(403);
            res.setMessage("Username is already used");
            return ResponseEntity.ok().body(res);
        }
        else    if(listusers.size() !=0 && listemail.size()!=0)
        {
            res.setStatus(404);
            res.setMessage("Both email and username are already used");
            return ResponseEntity.ok().body(res);
        }

        if(registerModel.getRepassword().equals(registerModel.getReconfirmpassword())==false)
        {
            res.setStatus(401);
            res.setMessage("Confirm password is different from password");
            return ResponseEntity.ok().body(res);
        }
        res.setStatus(0);
        registerService.save(registerModel);
        return ResponseEntity.ok().body(res);
    }

}
