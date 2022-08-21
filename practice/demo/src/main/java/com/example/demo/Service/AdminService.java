package com.example.demo.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.Userdtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminService extends JpaRepository<Admin, Integer> {
    @Query("select u from Admin u where u.email = :email")
    public Userdtls getuseremail(@Param("email") String email);
}
