package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wms.domain.Devise;

/**
 * Spring Data  repository for the {@link Devise } entity.
 */
@Repository
public interface DeviseRepository extends JpaRepository<Devise, Long>{
    
}
