package com.example.demo.controllers;

import com.example.demo.Service.BookingService;
import com.example.demo.model.Booking;
import com.example.demo.model.Message;
import com.example.demo.model.Userdtls;
import com.example.demo.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @RequestMapping("booking")

    public String booking(

            @RequestParam("param1") String usermail,
            @RequestParam("param2") String vaccinename,

            Model model, HttpSession session
    ){
        try {
//        System.out.println(usermail);
//        System.out.println(vaccinename);
        String today = String.valueOf(LocalDate.now());
        Booking booking = new Booking(usermail,vaccinename,today);
//        System.out.println(booking.getUser());
//        System.out.println(booking.getDate());
//        System.out.println(booking.getVaccine());

            this.bookingService.save(booking);
            Message m = new Message("Successfully Added "+vaccinename, "success");
            session.setAttribute("message", m);

            return "redirect:/user/index";
        }
        catch (Exception e){
            Message m = new Message("something went wrong try again", "error");
            session.setAttribute("message", m);

            System.out.println(e);
            return "redirect:/user/index";
        }

    }
}
