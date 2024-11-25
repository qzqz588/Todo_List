package com.example.todo.DTO.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserDetails{
        private Long id;
        private String username;
        private String password;
        private String email;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(
                        new SimpleGrantedAuthority("A"),
                        new SimpleGrantedAuthority("B"),
                        new SimpleGrantedAuthority("ROLE_ADMIN")
                );
        }

        public String getUsername() {
                return username;
        }

        public String getPassword() {
                return password;
        }
}

