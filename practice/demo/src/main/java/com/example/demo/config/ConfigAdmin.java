//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class ConfigAdmin extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public UserDetailsService getAdminDetailsService(){
//
//        return new AdminDetailsServicempl();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoderAdmin(){
//
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProviderAdmin(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//
//        daoAuthenticationProvider.setUserDetailsService(this.getAdminDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoderAdmin());
//
//        return  daoAuthenticationProvider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProviderAdmin());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/admin/**").hasRole("admin")
//                .antMatchers("/user/**").hasRole("user").antMatchers("/**")
//                .permitAll().and().formLogin().and().csrf().disable();
//    }
//}
