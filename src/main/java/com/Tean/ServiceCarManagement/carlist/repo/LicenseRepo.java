package com.Tean.ServiceCarManagement.carlist.repo;

import com.Tean.ServiceCarManagement.carlist.entity.license;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LicenseRepo extends JpaRepository<license, UUID>
{
    license save(license l);
    List<license> findByLicense(String l);
    long deleteByLicense(String l);
}
