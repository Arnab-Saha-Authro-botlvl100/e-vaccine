package com.example.demo.controllers;

import com.example.demo.Service.UserService;
import com.example.demo.Service.VaccineService;
import com.example.demo.model.Userdtls;
import com.example.demo.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserConroller {
    @Autowired
    private VaccineService vaccineService;
    @Autowired
    private UserService userService;
    @GetMapping ("/index")
    public String deshboard(Principal principal, Model model){
        Userdtls u = userService.getuserbyemail(principal.getName());


        String birth = u.birthday;
        System.out.println(birth);
        LocalDate dob = LocalDate.parse(birth);

        System.out.println("You are " + calculateAge(dob));
        u.setAge(0);
        u.setAge(calculateAge(dob));

        List<Vaccine> vaccineList =  vaccineService.findAll();
        List<Vaccine> selectedvaccine = new ArrayList<>();
        for(int i = 0; i<vaccineList.size(); i++){
            if(vaccineList.get(i).age <= u.getAge() ){
                if((vaccineList.get(i).gender.toLowerCase()).equals(u.getGender())  || vaccineList.get(i).gender.equals("Both")){
                selectedvaccine.add((vaccineList.get(i)));
                }
            }
        }
 //       selectedvaccine.add(u.getEmail());
//        for(int i = 0; i<selectedvaccine.size(); i++){
//            System.out.println(selectedvaccine.get(i).vaccinename+" "+selectedvaccine.get(i).getInformation()+);
//        }
        model.addAttribute("vaccinelist", selectedvaccine);
        model.addAttribute("userinfo", u);
        return "normal/user_deshboard";
    }
    public static int calculateAge(LocalDate dob)
    {

        LocalDate curDate = LocalDate.now();

        if ((dob != null) && (curDate != null))
        {
            int year = Period.between(dob, curDate).getYears();
            return year;
        }
        else
        {
            return 0;
        }
    }
}
