package com.shotaroi.multitenantsaastaskmanager.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "boards")
public class Board {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "org_id", nullable = false, columnDefinition = "uuid")
    private UUID orgId;

    @Column(name = "project_id", nullable = false, columnDefinition = "uuid")
    private UUID projectId;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    protected Board() {}

    public Board(UUID id, UUID orgId, UUID projectId, String name, Instant createdAt) {
        this.id = id;
        this.orgId = orgId;
        this.projectId = projectId;
        this.name = name;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public UUID getOrgId() { return orgId; }
    public UUID getProjectId() { return projectId; }
    public String getName() { return name; }
    public Instant getCreatedAt() { return createdAt; }
}
