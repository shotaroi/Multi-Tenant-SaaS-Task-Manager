package com.shotaroi.multitenantsaastaskmanager.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
        name = "memberships",
        uniqueConstraints = @UniqueConstraint(columnNames = {"org_id", "user_id"})
)
public class Membership {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "org_id", nullable = false, columnDefinition = "uuid")
    private UUID orgId;

    @Column(name = "user_id", nullable = false, columnDefinition = "uuid")
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    protected Membership() {}

    public Membership(UUID id, UUID orgId, UUID userId, Role role, Instant createdAt) {
        this.id = id;
        this.orgId = orgId;
        this.userId = userId;
        this.role = role;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public UUID getOrgId() { return orgId; }
    public UUID getUserId() { return userId; }
    public Role getRole() { return role; }
    public Instant getCreatedAt() { return createdAt; }
}
