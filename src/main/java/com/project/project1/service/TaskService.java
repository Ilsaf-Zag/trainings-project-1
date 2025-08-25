package com.project.project1.service;

import com.project.project1.model.Task;
import com.project.project1.records.response.TaskResponse;
import com.project.project1.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Page<TaskResponse> getAllTasks(int page, int limit) {
        Page<Task> taskPage = taskRepository.findAll(PageRequest.of(page, limit));

        return taskPage.map(task -> new TaskResponse(
                task.getId(),
                task.getTitle()
        ));
    }

    public Task createTask(String title){
        Task task = new Task();
        task.setTitle(title);

        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
