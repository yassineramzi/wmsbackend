package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wms.domain.PlanComptable;

/**
 * Spring Data  repository for the {@link PlanComptable } entity.
 */
@Repository
public interface PlanComptableRepository extends JpaRepository<PlanComptable, Long>{
    
}
