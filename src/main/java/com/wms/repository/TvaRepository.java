package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wms.domain.Tva;

/**
 * Spring Data  repository for the {@link Tva } entity.
 */
@Repository
public interface TvaRepository extends JpaRepository<Tva, Long>{
    
}
