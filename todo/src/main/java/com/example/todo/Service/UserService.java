package com.example.todo.Service;

import com.example.todo.DTO.User.User;
import com.example.todo.DTO.User.UserDto;
import com.example.todo.configuration.SecurityConfig;
import com.example.todo.configuration.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //의존성 주입
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입 로직
    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId()); // 수동으로 ID 설정
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());

        userRepository.save(user);
    }

    // 로그인 로직
    public User login(Long id, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (!passwordEncoder.matches(password,user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return user;
    }
}