package com.example.todo.configuration;

import com.example.todo.DTO.User.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // BcryptPasswordEncoder Bean을 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Bcrypt 방식의 암호화
    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        var userManager = new InMemoryUserDetailsManager();
//        UserDto userDto=new UserDto();
//        userManager.createUser(userDto);
//        return userManager;
//    }

    @Bean
    public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 필요에 따라 CSRF 비활성화
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/user/login", "/user/join", "/home", "/about", "/contact", // 페이지 경로
//                                "/css/**", "/js/**", "/images/**" // 정적 리소스 경로
//                        ).permitAll()
                        .requestMatchers(
                                "/user/login", "/user/join", // 페이지 경로
                                "/css/**", "/js/**", "/images/**" // 정적 리소스 경로
                        ).permitAll()
                        .anyRequest().authenticated() // 나머지 요청은 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/user/login") // 커스텀 로그인 페이지
                        .loginProcessingUrl("/user/login")//POST요청경로
                        .usernameParameter("id") //username 대신 id 로 하겠다
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout") // 로그아웃 설정
                        .permitAll()
                );

        return http.build();
    }
}
