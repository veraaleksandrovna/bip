package com.example.bip.config;


import com.example.bip.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService service;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(service);

    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                // мы включаем авторизацию
                .authorizeRequests()
                // для главной странички доступ доступен всем
                .antMatchers("/a/**", "/u/**").authenticated()
                .antMatchers("/", "/register", "/login").permitAll()
                // а для всех остальных мы требуем авторизацию
                .anyRequest().authenticated()
                .and()
                //включаем форму Login
                .formLogin()
                //Путь LoginPage
                .loginPage("/login")
                .defaultSuccessUrl("/u/hello")
                //Доступ всем :)
                .permitAll()
                .and()
                // Также включаем Logout и им тоже все могут пользоваться
                .logout()
                .permitAll();
    }

    // Обслуживает учетные записи

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


}

