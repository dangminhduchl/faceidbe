package com.Tean.ServiceCarManagement.register.repo;

import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsersRegisterRepo extends JpaRepository<Users, UUID> {
    List<Users> findByUsername(String username);
    Users save(Users users);
}
