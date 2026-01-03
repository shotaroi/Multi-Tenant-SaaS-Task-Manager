package com.shotaroi.multitenantsaastaskmanager.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "org_id", nullable = false, columnDefinition = "uuid")
    private UUID orgId;

    @Column(name = "board_id", nullable = false, columnDefinition = "uuid")
    private UUID boardId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "assignee_user_id", columnDefinition = "uuid")
    private UUID assigneeUserId;

    @Column(name = "created_by_user_id", nullable = false, columnDefinition = "uuid")
    private UUID createdByUserId;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected Task() {}

    public Task(UUID id, UUID orgId, UUID boardId, String title, String description,
                TaskStatus status, Priority priority, LocalDate dueDate,
                UUID assigneeUserId, UUID createdByUserId, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.orgId = orgId;
        this.boardId = boardId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.assigneeUserId = assigneeUserId;
        this.createdByUserId = createdByUserId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() { return id; }
    public UUID getOrgId() { return orgId; }
    public UUID getBoardId() { return boardId; }
}
