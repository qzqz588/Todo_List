package com.example.todo.Service;

import com.example.todo.DTO.User.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 해당 id유저를db에서 조회
        System.out.println("username: "+username);
        UserDto userDto = new UserDto();


        return userDto;
    }
}
