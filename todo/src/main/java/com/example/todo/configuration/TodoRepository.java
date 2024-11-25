package com.example.todo.configuration;

import com.example.todo.DTO.TodoDto;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface TodoRepository extends JpaRepository<TodoDto,Long>{

    }

