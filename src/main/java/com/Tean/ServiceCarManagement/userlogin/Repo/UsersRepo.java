package com.Tean.ServiceCarManagement.userlogin.Repo;

import com.Tean.ServiceCarManagement.userlogin.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsersRepo extends JpaRepository<Users, UUID> {
    List<Users> findByUsernameAndPassword(String username, String password);
    List<Users> findByUsername(String username);
}
