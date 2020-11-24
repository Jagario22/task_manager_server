package com.nure.taskmanager.tasks.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

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

    @ManyToOne
    @JoinColumn(name="category_id")
    private TaskCategory category;

    @NotBlank
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private EPriority value;
}
