package com.Tean.ServiceCarManagement.register.repo;

import com.Tean.ServiceCarManagement.register.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmailRepo extends JpaRepository<Email, UUID>
{
    List<Email> findByEmail(String email);
    Email save(Email email);
}
