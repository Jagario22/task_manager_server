package com.nure.taskmanager.tasks.service;

import com.nure.taskmanager.tasks.entity.Task;
import com.nure.taskmanager.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
        taskRepository.flush();
    }
}
