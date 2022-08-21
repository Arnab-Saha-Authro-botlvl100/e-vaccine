package com.example.demo.config;

import com.example.demo.Service.AdminService;
import com.example.demo.Service.UserService;
import com.example.demo.model.Admin;
import com.example.demo.model.Userdtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServicempl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userdtls user = userService.getuserbyemail(username);

        System.err.println("user info "+user.getRole());
        if (user == null){
            throw new UsernameNotFoundException("Not Found !!");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;
    }

}
