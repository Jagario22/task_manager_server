package com.nure.taskmanager.tasks.repository;

import com.nure.taskmanager.tasks.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();

    void deleteAllByCategoryId(Long category_id);

    List<Task> findAllByCategoryId(Long category_id);

    void deleteById(Long id);

    List<Task> findAllByEndTimeIsLessThanEqual(OffsetDateTime endTime);

    List<Task> findAllByCompletedIsFalse();

    List<Task> findAllByStartTimeIsGreaterThanEqualOrEndTimeIsGreaterThanEqual(OffsetDateTime startTime, OffsetDateTime endTime);

    List<Task> findAllByStartTimeIsBetweenOrEndTimeIsBetween(OffsetDateTime startTimeStart, OffsetDateTime startTimeEnd, OffsetDateTime endTimeStart, OffsetDateTime endTimeEnd);
}

