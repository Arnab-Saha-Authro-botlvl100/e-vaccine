//package com.example.demo.config;
//
//import com.example.demo.Service.AdminService;
//import com.example.demo.Service.UserService;
//import com.example.demo.model.Admin;
//import com.example.demo.model.Userdtls;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class AdminDetailsServicempl implements UserDetailsService {
//    @Autowired
//    private AdminService adminService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin admin = adminService.getadminbyemail(username);
//        System.err.println("user info "+admin);
//        if (admin == null){
//            throw new UsernameNotFoundException("Not Found !!");
//        }
//        CustomAdminDetails customAdminDetails = new CustomAdminDetails(admin);
//
//        return customAdminDetails;
//    }
//}
