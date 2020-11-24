package com.nure.taskmanager.tasks.controller;
import com.nure.taskmanager.tasks.entity.Task;
import com.nure.taskmanager.tasks.entity.TaskCategory;
import com.nure.taskmanager.tasks.service.CategoryService;
import com.nure.taskmanager.tasks.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final CategoryService categoryService;

    public TaskController(TaskService taskService, CategoryService categoryService) {
        this.taskService = taskService;
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getAll() {
        return taskService.findAll();
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Task task) {
        taskService.save(task);
        log.debug(task.toString());
    }

    @GetMapping("/id/{taskId}/category")
    @ResponseBody
    public TaskCategory getCategoryByTaskId(@PathVariable("taskId") Long taskId) {
        return categoryService.findByTaskId(taskId);
    }
}
