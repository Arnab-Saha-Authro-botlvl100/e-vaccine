package com.example.demo.controllers;

import com.example.demo.Service.UserService;
import com.example.demo.model.Userdtls;
//import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(path = "/loginprocess", method = RequestMethod.POST)
    public String processsignup(
                                @RequestParam("birthnumber") int bnum,
                                @RequestParam("password") String pass

    ){
        System.out.println( "bnumber "+bnum+" pass "+pass);
        return "";
    }

}
