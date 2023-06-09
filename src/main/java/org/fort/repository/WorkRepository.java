package org.fort.repository;

import org.fort.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
}
