package com.shotaroi.multitenantsaastaskmanager.repository;

import com.shotaroi.multitenantsaastaskmanager.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
    List<Board> findAllByOrgIdAndProjectId(UUID orgId, UUID projectId);
    Optional<Board> findByIdAndOrgId(UUID id, UUID orgId);
}
