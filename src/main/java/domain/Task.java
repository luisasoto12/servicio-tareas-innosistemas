package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private Integer status_id;
    private LocalDateTime due_date;
    @Column(nullable = false)
    private Integer project_id;
    @Column(nullable = false)
    private Long assignee_id;

    public Task() {
    }

    public Task(Long id, String title, String description, Integer status_id, LocalDateTime due_date,
            Integer project_id, Long assignee_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status_id = status_id;
        this.due_date = due_date;
        this.project_id = project_id;
        this.assignee_id = assignee_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Long getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(Long assignee_id) {
        this.assignee_id = assignee_id;
    }

}
