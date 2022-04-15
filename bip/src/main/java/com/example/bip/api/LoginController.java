package com.example.bip.api;

import com.example.bip.domain.User;
import com.example.bip.domain.UserRole;
import com.example.bip.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService service;

    @PostMapping("/login")
    public String register(@ModelAttribute("user") User user, HttpSession httpSession)
    {
        service.loadUserByUsername(user.getLogin());
        user.setRole(UserRole.USER);
        httpSession.setAttribute("user", user);
        return "hello";
    }

    @GetMapping("/login")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "login";
    }


}
