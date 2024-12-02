package com.example.todo.configuration;

import com.example.todo.DTO.User.UserDto;
import com.example.todo.DTO.User.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
    public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
//    //Select COUNT(*) FROM User WHERE id = :id id가 존재한다면 false 반환
//    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.id = :id")
//    boolean existsByCustomId(@Param("id") Long id);


}
