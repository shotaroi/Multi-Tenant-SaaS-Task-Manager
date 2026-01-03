package com.shotaroi.multitenantsaastaskmanager.repository;

import com.shotaroi.multitenantsaastaskmanager.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MembershipRepository extends JpaRepository<Membership, UUID> {
    Optional<Membership> findByOrgIdAndUserId(UUID orgId, UUID userId);
    boolean existsByOrgIdAndUserId(UUID orgId, UUID userId);
}
