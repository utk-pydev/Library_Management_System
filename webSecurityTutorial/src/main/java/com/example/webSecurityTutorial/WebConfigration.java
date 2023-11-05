package com.example.webSecurityTutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfigration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Karan")
                .password("karan123")
                .authorities("qa")
                .and()
                .withUser("Rashmi")
                .password("rashmi123")
                .authorities("dev");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/testcode/**").hasAnyAuthority("qa")
                .antMatchers("/developcode/**").hasAnyAuthority("dev")
                .antMatchers("/accessserver/**").hasAnyAuthority("dev", "qa")
                .antMatchers("/home").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    PasswordEncoder getPE(){
        return NoOpPasswordEncoder.getInstance();
    }
}