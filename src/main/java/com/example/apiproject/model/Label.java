package com.example.apiproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "labels", schema = "api")
public class Label {
    @Id
    @Column(name = "label_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    @Size(max = 7)
    @Column(name = "color", length = 7)
    private String color;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}