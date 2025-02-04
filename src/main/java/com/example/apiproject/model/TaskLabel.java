package com.example.apiproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "task_labels", schema = "api")
public class TaskLabel {
    @EmbeddedId
    private TaskLabelId id;

    @MapsId("taskId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private com.example.apiproject.model.Task task;

    @MapsId("labelId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "label_id", nullable = false)
    private Label label;

    @Column(name = "created_at")
    private Instant createdAt;

}