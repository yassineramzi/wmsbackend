package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wms.domain.Dossier;

/**
 * Spring Data  repository for the {@link Dossier } entity.
 */
@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long> {

}
