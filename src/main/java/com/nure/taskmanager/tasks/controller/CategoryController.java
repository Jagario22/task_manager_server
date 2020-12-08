package com.nure.taskmanager.tasks.controller;

import com.nure.taskmanager.tasks.entity.TaskCategory;
import com.nure.taskmanager.tasks.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TaskCategory> getAll() {
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public TaskCategory create(@RequestBody TaskCategory taskCategory) {
        return categoryService.save(taskCategory);
    }

    @DeleteMapping("id/{categoryId}/delete")
    public void deleteById(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteById(categoryId);
    }
}
