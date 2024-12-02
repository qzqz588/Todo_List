package com.example.todo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("activePage", "home");
        List<Map<String, Object>> carouselSlides = List.of(
                Map.of("title", "로이드밤", "subtitle", "소연", "image", "soyeon.jpeg", "active", true),
                Map.of("title", "로이드밤", "subtitle", "도예", "image", "doye.jpeg", "active", false),
                Map.of("title", "로이드밤", "subtitle", "수빈", "image", "subin.jpeg", "active", false)
        );
        model.addAttribute("carouselSlides", carouselSlides);
        //연재 요청과 연결된 인증 정보 반환
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "home"; // home.html 템플릿
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("activePage", "about");
        return "about"; // about.html 템플릿
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("activePage", "contact");
        return "contact"; // contact.html 템플릿
    }
}
