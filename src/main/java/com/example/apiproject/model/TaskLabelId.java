package com.example.apiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class TaskLabelId implements java.io.Serializable {
    private static final long serialVersionUID = 1788343642065369371L;
    @NotNull
    @Column(name = "task_id", nullable = false)
    private Integer taskId;

    @NotNull
    @Column(name = "label_id", nullable = false)
    private Integer labelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskLabelId entity = (TaskLabelId) o;
        return Objects.equals(this.labelId, entity.labelId) &&
                Objects.equals(this.taskId, entity.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labelId, taskId);
    }

}