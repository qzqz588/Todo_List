package com.example.todo.DTO.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 생성
    private Long id;

    @Column(nullable = false, unique = true) // username은 고유값
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true) // email도 고유값
    private String email;
    private String role;
}