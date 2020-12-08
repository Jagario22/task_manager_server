package com.nure.taskmanager.tasks.controller;

import com.nure.taskmanager.tasks.entity.Task;
import com.nure.taskmanager.tasks.service.CategoryService;
import com.nure.taskmanager.tasks.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
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


    @RequestMapping(method = RequestMethod.GET, path = "/unfinished")
    @ResponseBody
    public List<Task> getAllUnfinished() {
        return taskService.findAllByCompletedIsFalse();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/during/days/{startDay}/{endDay}")
    @ResponseBody
    public List<Task> getALLTasksDuringDays(@PathVariable("startDay") String start, @PathVariable("endDay") String end) {
        return taskService.findAllByStartTimeIsBetweenOrEndTimeIsBetween(OffsetDateTime.parse(start), OffsetDateTime.parse(end));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/during/planned/{startDay}")
    @ResponseBody
    public List<Task> getAllPlannedTasks(@PathVariable("startDay") String start) {
        return taskService.findAllStartOrIsGreaterThan(OffsetDateTime.parse(start));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/gone/{endDay}")
    @ResponseBody
    public List<Task> getAllGoneTasks(@PathVariable("endDay") String end) {
        return taskService.findAllByEndTimeIsLessThanEqual(OffsetDateTime.parse(end));
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Task task) {
        taskService.save(task);
        log.debug(task.toString());
    }


    @DeleteMapping("/category/{categoryId}/delete")
    public void deleteAllByCategoryId(@PathVariable("categoryId") Long categoryId) {
        taskService.deleteAllByCategoryId(categoryId);
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public List<Task> getCategoryByTaskId(@PathVariable("id") Long categoryId) {
        return taskService.findAllByCategoryId(categoryId);
    }

    @DeleteMapping("delete/id/{taskId}")
    @ResponseBody
    public void deleteTaskById(@PathVariable("taskId") Long taskId) {
        taskService.deleteById(taskId);
    }
}
