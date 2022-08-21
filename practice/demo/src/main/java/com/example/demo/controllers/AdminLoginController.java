package com.example.demo.controllers;

import com.example.demo.Service.BookingService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/index")
    public String adminpage(Model model){
        List<Booking> bookings = bookingService.findAll();
        model.addAttribute("bookinglist", bookings);
        return "admin/adminpage";
    }
}
