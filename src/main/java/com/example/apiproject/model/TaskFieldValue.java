package com.example.apiproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task_field_values", schema = "api")
public class TaskFieldValue {
    @Id
    @Column(name = "field_value_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    private com.example.apiproject.model.TaskField field;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private com.example.apiproject.model.Task task;

    @Lob
    @Column(name = "value")
    private String value;

}