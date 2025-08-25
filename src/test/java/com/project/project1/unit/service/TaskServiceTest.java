package com.project.project1.unit.service;

import com.project.project1.model.Task;
import com.project.project1.records.request.CreateTaskRequest;
import com.project.project1.repository.TaskRepository;
import com.project.project1.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void createTask_ShouldReturnSavedTask(){
        CreateTaskRequest request = new CreateTaskRequest("Test Title");

        Task savedTask = new Task();
        savedTask.setTitle("Test Title");

        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        Task result = taskService.createTask(request.title());

        assertNotNull(result);
        assertEquals("Test Title", result.getTitle());
        verify(taskRepository,times(1)).save(any(Task.class));
    }
}
