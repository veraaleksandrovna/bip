package com.example.bip.api.registration;

import com.example.bip.domain.User;
import com.example.bip.domain.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping("/register")
    public String register(@ModelAttribute("fashUser") User user)
    {
        user.setRole(UserRole.USER);
        RegistrationRequest request = new RegistrationRequest(user);
        return service.register(request);
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
}
