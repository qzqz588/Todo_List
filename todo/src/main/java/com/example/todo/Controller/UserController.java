package com.example.todo.Controller;

import com.example.todo.DTO.User.UserDto;
import com.example.todo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/join") //todo 연결 메서드
    public String userJoinPage() {
        return "User/join";
    }

    @PostMapping("/user/join")
    public String userJoinSubmit(@ModelAttribute UserDto userDto) {
        userService.registerUser(userDto); // 유저 등록 로직 실행
        return "redirect:/user/login"; // 회원가입 후 로그인 페이지로 리다이렉트
    }

    @GetMapping("/user/login")
    public String userloginPage() {
        return "User/login";
    }
    @PostMapping("/user/login")
    public ResponseEntity<String> userLogin(@RequestParam Long id,
                                            @RequestParam String password) throws IllegalAccessException {
        userService.login(id, password);
        return ResponseEntity.ok("로그인 성공!");
    }
}

