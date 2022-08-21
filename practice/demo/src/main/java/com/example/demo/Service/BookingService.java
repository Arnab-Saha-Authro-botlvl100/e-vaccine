package com.example.demo.Service;

import com.example.demo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingService extends JpaRepository<Booking, Integer> {

//    @Query("delete from Booking u where u.id = :booking_id")
//    public List<Booking> delete(@Param("booking_id") int booking_id);
}
