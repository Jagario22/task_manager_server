package com.nure.taskmanager.tasks.service;

import com.nure.taskmanager.tasks.entity.Task;
import com.nure.taskmanager.tasks.entity.TaskCategory;
import com.nure.taskmanager.tasks.repository.CategoryRepository;
import com.nure.taskmanager.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final  TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;


    public CategoryService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }
    public TaskCategory findByTaskId(Long taskId) {
        Task task = taskRepository.findById(taskId).get();
        return task.getCategory();
    }

    public List<TaskCategory> findAll() {
        return categoryRepository.findAll();
    }

    public TaskCategory save(TaskCategory taskCategory) {
        return categoryRepository.save(taskCategory);
    }

    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
