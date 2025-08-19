package com.project.project1.service;

import com.project.project1.model.Task;
import com.project.project1.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
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
