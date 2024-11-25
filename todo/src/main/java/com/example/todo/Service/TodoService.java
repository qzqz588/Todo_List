package com.example.todo.Service;

import com.example.todo.DTO.TodoDto;
import com.example.todo.configuration.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;
    private final List<TodoDto> todoList = new ArrayList<>();
    public List<TodoDto> readAll(){
        return todoList;
    }
    public TodoDto creatTodo(String content){
            TodoDto todo = new TodoDto();
            todo.setContent(content); // 사용자가 입력한 내용
            todo.setDone(false);      // 기본값 설정
            return todoRepository.save(todo); // DB에 저장

    }
//    public void update(Long id){
//        TodoDto todoDto = new TodoDto(id);
//
//    }
    public TodoDto select(Long id){

        return null;
    }
}
