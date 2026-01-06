package com.shotaroi.multitenantsaastaskmanager.repository;

import com.shotaroi.multitenantsaastaskmanager.entity.OrganizationMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrganizationMemberRepository
        extends JpaRepository<OrganizationMember, UUID> {

    boolean existsByUserIdAndOrgId(UUID userId, UUID orgId);
}
