package com.example.apiproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "task_fields", schema = "api")
public class TaskField {
    @Id
    @Column(name = "field_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "field_type")
    private String fieldType;

    @Column(name = "is_required")
    private Boolean isRequired;

    @Column(name = "created_at")
    private Instant createdAt;

}