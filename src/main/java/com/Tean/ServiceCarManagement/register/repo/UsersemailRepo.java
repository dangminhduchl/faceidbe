package com.Tean.ServiceCarManagement.register.repo;

import com.Tean.ServiceCarManagement.register.entity.Usersemail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersemailRepo extends JpaRepository<Usersemail, UUID>
{
    Usersemail save(Usersemail usersemail);
}
