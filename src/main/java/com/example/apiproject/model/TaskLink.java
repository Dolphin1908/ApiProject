package com.example.apiproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "task_links", schema = "api")
public class TaskLink {
    @Id
    @Column(name = "link_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private com.example.apiproject.model.Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linked_task_id")
    private com.example.apiproject.model.Task linkedTask;

    @Size(max = 50)
    @Column(name = "link_type", length = 50)
    private String linkType;

    @Column(name = "created_at")
    private Instant createdAt;

}