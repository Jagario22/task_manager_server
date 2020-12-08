package com.nure.taskmanager.tasks.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String title;

    private String description;

    @Column(name = "start_time", nullable = false)
    private OffsetDateTime startTime;

    @Column(name = "end_time")
    private OffsetDateTime endTime;

    private boolean completed;

    @Column(name = "completed_time")
    private OffsetDateTime completedDateTime;

    @ManyToOne
    @JoinColumn(name="category_id")
    private TaskCategory category;

    @Enumerated(EnumType.STRING)
    private EPriority priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return isCompleted() == task.isCompleted() &&
                Objects.equals(getId(), task.getId()) &&
                Objects.equals(getTitle(), task.getTitle()) &&
                Objects.equals(getDescription(), task.getDescription()) &&
                Objects.equals(getStartTime(), task.getStartTime()) &&
                Objects.equals(getEndTime(), task.getEndTime()) &&
                Objects.equals(getCategory(), task.getCategory()) &&
                getPriority() == task.getPriority();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getStartTime(), getEndTime(), isCompleted(), getCategory(), getPriority());
    }
}
