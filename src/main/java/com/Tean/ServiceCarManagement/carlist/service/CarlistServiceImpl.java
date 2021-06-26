package com.Tean.ServiceCarManagement.carlist.service;

import com.Tean.ServiceCarManagement.carlist.entity.carlist;
import com.Tean.ServiceCarManagement.carlist.entity.license;
import com.Tean.ServiceCarManagement.carlist.model.CarlistModel;
import com.Tean.ServiceCarManagement.carlist.repo.CarlistRepo;
import com.Tean.ServiceCarManagement.carlist.repo.LicenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarlistServiceImpl implements CarlistService
{
    @Autowired
    private CarlistRepo carlistRepo;

    @Autowired
    private LicenseRepo licenseRepo;

    @Override
    public void save(CarlistModel model)
    {
        license l = new license();
        l.setLicense(model.getLicense());
        licenseRepo.save(l);

        carlist car = new carlist();
        car.setDriver(model.getDriver());
        car.setLicense(model.getLicense());
        car.setBrand(model.getBrand());
        car.setManufacturedate(model.getManufacturedate());
        car.setCartype(model.getCartype());
        car.setRegisterdate(model.getRegisterdate());
        car.setState(model.getState());
        carlistRepo.save(car);


    }

    @Override
    public List<carlist> findAll() {
        return carlistRepo.findAll();
    }

    @Override
    public void deleteById(int id)
    {
        List<carlist> list = carlistRepo.deleteById(id);
        licenseRepo.deleteByLicense(list.get(0).getLicense());
    }

    @Override
    public List<license> findByLicense(CarlistModel model) {
        return licenseRepo.findByLicense(model.getLicense());
    }

    @Override
    public List<carlist> findById(int id) {
        return carlistRepo.findById(id);
    }
}
