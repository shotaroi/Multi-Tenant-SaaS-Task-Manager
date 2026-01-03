package com.shotaroi.multitenantsaastaskmanager.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "org_id", nullable = false, columnDefinition = "uuid")
    private UUID orgId;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    protected Project() {}

    public Project(UUID id, UUID orgId, String name, Instant createdAt) {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public UUID getOrgId() { return orgId; }
    public String getName() { return name; }
    public Instant getCreatedAt() { return createdAt; }
}
