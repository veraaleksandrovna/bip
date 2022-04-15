package com.example.bip.service;

import com.example.bip.domain.User;
import com.example.bip.reposirories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    UserRepository userRepository;
    //BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String regiserNewUser(User user){
        Optional<User> userOptional = userRepository.findUserByLogin(user.getLogin());

        if (userOptional.isPresent())
        {
            throw new IllegalStateException("Данный username занят");
        }
        else
        {
        //String encodedPassword = passwordEncoder.encode(user.getPassword());
        //user.setPassword(encodedPassword);
            userRepository.save(user);
        }
        //TODO: send confirmation token
        return "redirect:/login";
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findUserByLogin(login).get();
    }


}
