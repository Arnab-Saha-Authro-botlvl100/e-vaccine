package com.example.demo.Service;

//import com.example.demo.model.Admin;
import com.example.demo.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineService extends JpaRepository<Vaccine, Integer> {
}