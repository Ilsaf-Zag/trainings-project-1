package com.project.project1.controller;

import com.project.project1.model.Task;
import com.project.project1.records.request.CreateTaskRequest;
import com.project.project1.records.response.TaskResponse;
import com.project.project1.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks().stream().map(task -> new TaskResponse(task.getId(), task.getTitle())).toList();
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        Task task = taskService.createTask(request.title());

        TaskResponse response = new TaskResponse(task.getId(), task.getTitle());
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
