package com.example.housemaid.controller;


import com.example.housemaid.dto.ApiResponse;
import com.example.housemaid.model.User;
import com.example.housemaid.servise.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/end")
public class EndController {
    private final TaskService taskService;


    @PutMapping(value = "/done/{id}")
    public ResponseEntity done(@PathVariable Integer id) {
        taskService.done(id);
        return ResponseEntity.status(201).body(new ApiResponse("done", 201));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity getTasks(@AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(taskService.getTasks(user));

    }
}
