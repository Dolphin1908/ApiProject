package com.example.apiproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "task_relations", schema = "api")
public class TaskRelation {
    @Id
    @Column(name = "task_relation_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id_1")
    private com.example.apiproject.model.Task taskId1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id_2")
    private com.example.apiproject.model.Task taskId2;

    @Lob
    @Column(name = "relation_type")
    private String relationType;

    @Column(name = "created_at")
    private Instant createdAt;

}