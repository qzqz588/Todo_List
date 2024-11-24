package com.example.todo.Controller;

import com.example.todo.DTO.TodoDto;
import com.example.todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TodoController {

    @Autowired
    TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @RequestMapping("/todo") //todo 연결 메서드
    public String todo(Model model){
        List<TodoDto> list = todoService.readAll(); //list 전체 조회 메서드
        model.addAttribute("todoList",list); //todolist로 list 받아오기
        return "/todo";
    }
    @RequestMapping("/")
    public String home(){

        return "redirect:/todo";
    }

    @PostMapping("/todo/create")
    public String create(@RequestParam("todo-desc") String content){
        System.out.println("Content received: " + content);
        todoService.creatTodo(content);
        return "redirect:/todo";
    }
//    @PostMapping("/todo/{id}/update")
//    public String update(@PathVariable("id") Long id, @RequestParam("todo-desc") String content) {
//        System.out.println("Updating todo with ID: " + id + " to content: " + content);
//        todoService.updateTodo(id, content);
//        return "redirect:/todo";
//    }


}
