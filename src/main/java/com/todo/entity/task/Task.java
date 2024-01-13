package com.todo.entity.task;

import com.todo.entity.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESC")
    private String desc;

    @Column(name = "ESTIMATED_AT")
    private LocalDate estimatedAt;

    @Column(name = "DONE_AT")
    private LocalDate doneAt;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private User user;

    public Task() {
    }

    public Task(String desc, LocalDate estimatedAt, LocalDate doneAt, User user) {
        this.id = id;
        this.desc = desc;
        this.estimatedAt = estimatedAt;
        this.doneAt = doneAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getEstimatedAt() {
        return estimatedAt;
    }

    public void setEstimatedAt(LocalDate estimatedAt) {
        this.estimatedAt = estimatedAt;
    }

    public LocalDate getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(LocalDate doneAt) {
        this.doneAt = doneAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(desc, task.desc) && Objects.equals(estimatedAt, task.estimatedAt) && Objects.equals(doneAt, task.doneAt) && Objects.equals(user, task.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, estimatedAt, doneAt, user);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", estimatedAt=" + estimatedAt +
                ", doneAt=" + doneAt +
                ", user=" + user +
                '}';
    }
}
