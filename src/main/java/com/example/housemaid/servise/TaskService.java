package com.example.housemaid.servise;

import com.example.housemaid.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import com.example.housemaid.model.Task;
import com.example.housemaid.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getTasks(User user){
        return taskRepository.findByUserId(user.getId());
    }
    public List<Task> getTasksEND(){


        return taskRepository.findAll();
    }

    public void addTask(Task task,User user ){
        taskRepository.save(task);
    }

    public void done(Integer id) {
       Task task = taskRepository.getById(id);
       task.setState(true);
        taskRepository.save(task);
    }

    public void delete(Integer id) {
        Task task = taskRepository.getById(id);
        taskRepository.delete(task);
    }
}
