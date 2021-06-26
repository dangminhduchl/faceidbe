package com.Tean.ServiceCarManagement.carlist.repo;

import com.Tean.ServiceCarManagement.carlist.entity.carlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarlistRepo extends JpaRepository<carlist, UUID>
{
    carlist save(carlist car);
    List<carlist> findAll();
    List<carlist> findById(int id);
    List<carlist> deleteById(int id);
}
