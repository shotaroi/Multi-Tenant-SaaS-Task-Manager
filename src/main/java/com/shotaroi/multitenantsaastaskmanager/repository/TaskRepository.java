package com.shotaroi.multitenantsaastaskmanager.repository;

import com.shotaroi.multitenantsaastaskmanager.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    Optional<Task> findByIdAndOrgId(UUID id, UUID orgId);
    Page<Task> findAllByOrgIdAndBoardId(UUID orgId, UUID boardId, Pageable pageable);
}
