package com.wms.service;

import java.util.List;

import com.wms.dto.PlanComptableDTO;

public interface PlanComptableService {
    PlanComptableDTO create(final PlanComptableDTO planComptableDTO);
    List<PlanComptableDTO> findAll();
    void delete(final Long id);
}
