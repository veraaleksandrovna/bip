package com.example.bip.api.registration;

import com.example.bip.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    //private final EmailValidator emailValidator;
    public String register(RegistrationRequest request){
//        boolean IsValidEmail = emailValidator.test(request.getEmail());
//
//        if(!IsValidEmail){
//            throw new IllegalStateException("Email not valid");
//        }
        return userService.regiserNewUser(request.getUser());
    }
}
