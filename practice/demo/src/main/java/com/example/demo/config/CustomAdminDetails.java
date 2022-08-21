//package com.example.demo.config;
//
//import com.example.demo.model.Admin;
//import com.example.demo.model.Userdtls;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//public class CustomAdminDetails implements UserDetails {
//    private Admin admin;
//
//    public CustomAdminDetails(Admin admin) {
//        super();
//        this.admin = admin;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority simpleGrantedAuthority =  new SimpleGrantedAuthority(admin.getRole());
//        return List.of(simpleGrantedAuthority);
//    }
//
//    @Override
//    public String getPassword() {
//        return admin.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return String.valueOf(admin.getAdminmail());
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
