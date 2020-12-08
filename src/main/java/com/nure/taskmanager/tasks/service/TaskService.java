package com.nure.taskmanager.tasks.service;

import com.nure.taskmanager.tasks.entity.Task;
import com.nure.taskmanager.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
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

    @Transactional
    public void deleteAllByCategoryId(Long categoryId) {
        taskRepository.deleteAllByCategoryId(categoryId);
    }

    public List<Task> findAllByCategoryId(Long categoryId) {
        return taskRepository.findAllByCategoryId(categoryId);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAllByCompletedIsFalse() {
        return taskRepository.findAllByCompletedIsFalse();
    }

    public void deleteById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> findAllStartOrIsGreaterThan(OffsetDateTime d1) {
        return taskRepository.findAllByStartTimeIsGreaterThanEqualOrEndTimeIsGreaterThanEqual(d1, d1);
    }

    public List<Task> findAllByStartTimeIsBetweenOrEndTimeIsBetween(OffsetDateTime d1, OffsetDateTime d2) {
        return taskRepository.findAllByStartTimeIsBetweenOrEndTimeIsBetween(d1, d2, d1, d2);
    }


    public List<Task> findAllByEndTimeIsLessThanEqual(OffsetDateTime d1) {
        return taskRepository.findAllByEndTimeIsLessThanEqual(d1);
    }

}
