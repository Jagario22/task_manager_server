package com.nure.taskmanager.tasks.repository;

import com.nure.taskmanager.tasks.entity.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<TaskCategory, Long> {
    List<TaskCategory> findAll();
}
