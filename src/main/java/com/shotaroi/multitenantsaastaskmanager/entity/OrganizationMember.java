package com.shotaroi.multitenantsaastaskmanager.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "organization_members")
public class OrganizationMember {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "org_id", nullable = false)
    private UUID orgId;

    // getters/setters
}
