package com.shotaroi.multitenantsaastaskmanager.repository;

import com.shotaroi.multitenantsaastaskmanager.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {}
