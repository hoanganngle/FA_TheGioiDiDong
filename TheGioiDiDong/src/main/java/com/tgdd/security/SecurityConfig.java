package com.tgdd.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig {
	protected void configure(HttpSecurity http) throws Exception {
        http               
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        
        .permitAll()

        .loginPage("/login")
        .usernameParameter("txtUsername")
        .passwordParameter("txtPassword")
}
