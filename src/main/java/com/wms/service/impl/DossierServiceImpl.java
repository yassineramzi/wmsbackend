package com.wms.service.impl;

import org.springframework.stereotype.Service;

import com.wms.service.DossierService;
import com.wms.service.dto.DossierDTO;

@Service
public class DossierServiceImpl implements DossierService {

    @Override
    public DossierDTO create(DossierDTO dossierDTO) {
        return new DossierDTO();
    }
    
}
