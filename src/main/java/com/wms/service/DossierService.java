package com.wms.service;

import java.util.List;

import com.wms.dto.DossierDTO;

public interface DossierService {
    DossierDTO create(final DossierDTO dossierDTO);
    List<DossierDTO> findAll();
    void delete(final Long id);
}
