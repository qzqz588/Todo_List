package com.example.todo.configuration;

import com.example.todo.DTO.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
//    //Select COUNT(*) FROM User WHERE id = :id id가 존재한다면 false 반환
//    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.id = :id")
//    boolean existsByCustomId(@Param("id") Long id);


}
