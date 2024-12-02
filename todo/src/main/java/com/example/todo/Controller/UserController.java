package com.example.todo.Controller;

import com.example.todo.DTO.User.UserEntity;
import com.example.todo.configuration.UserDetails.CustomUserDetailsService;
import com.example.todo.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomUserDetailsService customer;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/join")
    public String registerForm(Model model) {
        return "/user/join";
    }

    @PostMapping("/user/join")
    public String registerSubmit(@ModelAttribute UserEntity userEntity) {
        System.out.println("username : " + userEntity.getUsername());
        System.out.println("userEmail" + userEntity.getEmail());
        userService.registerUser(userEntity);
        return "redirect:/home";
    }


}