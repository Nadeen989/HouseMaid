package com.example.housemaid.controller;


import com.example.housemaid.dto.ApiResponse;
import com.example.housemaid.servise.TaskService;
import lombok.RequiredArgsConstructor;
import com.example.housemaid.model.Task;
import com.example.housemaid.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {
    private final TaskService taskService;


    @GetMapping("/get")
    public ResponseEntity getTasks() {
        return ResponseEntity.status(200).body(taskService.getTasksEND());
    }
    @PostMapping("/add")
    public ResponseEntity addTask(@RequestBody Task task, @AuthenticationPrincipal User user){
        taskService.addTask(task,user);
        return ResponseEntity.status(201).body(new ApiResponse("New Task added!",201));

    }


    @PutMapping(value = "/done/{id}")
    public ResponseEntity done(@PathVariable Integer id)  {

        taskService.done(id);
    return ResponseEntity.status(201).body(new ApiResponse("done",201));
   }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id)  {

        taskService.delete(id);
        return ResponseEntity.status(201).body(new ApiResponse("delete task !",201));
    }
}
