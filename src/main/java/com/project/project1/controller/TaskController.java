package com.project.project1.controller;

import com.project.project1.dto.TaskDto;
import com.project.project1.model.Task;
import com.project.project1.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks().stream().map(task-> new TaskDto(task.getId(),task.getTitle())).toList();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
