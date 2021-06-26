package com.Tean.ServiceCarManagement.carlist.controller;

import com.Tean.ServiceCarManagement.carlist.entity.license;
import com.Tean.ServiceCarManagement.carlist.model.AuthModel;
import com.Tean.ServiceCarManagement.carlist.model.CarlistEraserModel;
import com.Tean.ServiceCarManagement.carlist.model.CarlistModel;
import com.Tean.ServiceCarManagement.carlist.repo.CarlistRepo;
import com.Tean.ServiceCarManagement.carlist.service.CarlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class CarlistAPIController {
    @Autowired
    private CarlistService carlistService;

    @GetMapping("/carlist/get")
    public ResponseEntity<?> carlistget(Principal principal) {
        return ResponseEntity.ok().body(carlistService.findAll());
    }

    @DeleteMapping("/carlist/delete/{model}")
    public ResponseEntity<?> carlistdelete(Principal principal, @PathVariable List<Integer> model)
    {
        for(int id : model)
        {
            carlistService.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/carlist/add")
    public ResponseEntity<?> carlistadd(Principal principal, @RequestBody CarlistModel model)
    {
        AuthModel res = new AuthModel();
        List<license> list = carlistService.findByLicense(model);
        if(list.size()!=0)
        {
            res.setStatus(1);
            res.setMessage("License plate is already in use");
            return ResponseEntity.ok().body(res);
        }
        res.setStatus(0);
        carlistService.save(model);
        return  ResponseEntity.ok().body(res);
    }

}
