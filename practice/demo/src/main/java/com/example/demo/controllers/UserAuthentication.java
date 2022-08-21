package com.example.demo.controllers;

import com.example.demo.Service.UserService;
import com.example.demo.model.Userdtls;
//import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UserAuthentication {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/processsignup", method = RequestMethod.POST)
    public String processsignup(
//                                @RequestParam("email") String uemail,
//                                @RequestParam("username") String uname,
//                                @RequestParam("birthnumber") int ubirthnum,
//                                @RequestParam("gender") String gender,
//                                @RequestParam("password") String upass,
//                                @RequestParam("phone") String uphn,
//                                @RequestParam("address") String uaddress
            @ModelAttribute("user") Userdtls userr, Model model
            ){
        System.out.println(userr.birthday);
        userr.setPassword(passwordEncoder.encode(userr.getPassword()));
        this.userService.save(userr);
        model.addAttribute("user_info", userr);
//        return "email given "+uemail+" name: "+uname+" birthnumber: "+ubirthnum+" gender: "+gender+" pass: "+upass+" phn:"+uphn+" address: "+uaddress;
        return "index";
    }

}
