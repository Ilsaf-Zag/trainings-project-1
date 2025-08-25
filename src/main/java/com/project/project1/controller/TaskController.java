package com.project.project1.controller;

import com.project.project1.model.Task;
import com.project.project1.records.request.CreateTaskRequest;
import com.project.project1.records.response.TaskResponse;
import com.project.project1.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<Page<TaskResponse>> getAllTasks(@RequestParam(defaultValue = "0") Integer page,
                                          @RequestParam(defaultValue = "10") Integer limit) {
        Page<TaskResponse> taskPage = taskService.getAllTasks(page,limit);
        return ResponseEntity.ok(taskPage);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        Task task = taskService.createTask(request.title());

        TaskResponse response = new TaskResponse(task.getId(), task.getTitle());
        return ok(response);

    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
