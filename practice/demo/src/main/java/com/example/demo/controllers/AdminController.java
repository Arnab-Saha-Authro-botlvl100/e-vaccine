package com.example.demo.controllers;

import com.example.demo.Service.AdminService;
import com.example.demo.Service.BookingService;
import com.example.demo.Service.VaccineService;
import com.example.demo.model.Admin;
//import com.services.UserService;
import com.example.demo.model.Booking;
import com.example.demo.model.Message;
import com.example.demo.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AdminService adminService;

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private BookingService bookingService;


    @GetMapping("/adminsignup")
    public String showadminsignuppage() {
        return "admin/adminsignup";
    }

    @RequestMapping(path = "/adminsignup", method = RequestMethod.POST)
    public String signupadmin(@ModelAttribute("admin") Admin admin, Model model) {
        admin.setRole("ROLE_admin");
//        System.out.println(admin.getAdminmail());
//        System.out.println(admin.getPassword());
//        System.out.println(admin.getRole());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        this.adminService.save(admin);
        return "admin/adminpage";
    }

    @RequestMapping(path = "/admin/addvaccines", method = RequestMethod.POST)
    public String vaccineadd(@ModelAttribute("vaccine") Vaccine vaccine, Model model) {
        System.out.println(vaccine.getAge());
        this.vaccineService.save(vaccine);
        return "redirect:/admin/index";
    }

    @RequestMapping("deletebooking")
    public String deletebooking(
            @RequestParam("param1") int booking_id, HttpSession session, Model model
    ) {
        try {
            System.out.println(booking_id);
//            List<Booking> booking = bookingService.delete(booking_id);
            Booking booking = bookingService.getReferenceById(booking_id);
            bookingService.delete(booking);
//            List<Booking> selectedbookingList = new ArrayList<>();
//            for (int i = 0; i <= booking.size(); i++) {
//                if (booking.get(i).getId() != booking_id) {
//                    selectedbookingList.add(booking.get(i));
//                }
//            }
            Message m = new Message("Succecfully deleted", "success");
            model.addAttribute("bookingList", bookingService.findAll());
            return "admin/adminpage.html";

        } catch (Exception e) {

            List<Booking> selectedbookingList = bookingService.findAll();
            Message m = new Message("Something Went Wrong", "danger");
            model.addAttribute("bookingList", selectedbookingList);
            return "admin/adminpage.html";
        }

    }
}
