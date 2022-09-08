package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wms.domain.Tiers;

/**
 * Spring Data  repository for the {@link Tiers } entity.
 */
@Repository
public interface TiersRepository extends JpaRepository<Tiers, Long> {

}
