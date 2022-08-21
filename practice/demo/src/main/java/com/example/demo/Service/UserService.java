package com.example.demo.Service;

import com.example.demo.model.Userdtls;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserService extends JpaRepository<Userdtls, Integer> {
    @Query("select u from Userdtls u where u.email = :email")
    public Userdtls getuserbyemail(@Param("email") String email);
}
