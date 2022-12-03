package com.wms.service;

import java.util.List;

import com.wms.service.dto.DossierDTO;

public interface DossierService {
    DossierDTO create(final DossierDTO dossierDTO);
    List<DossierDTO> findAll();
    void delete(final Long id);
  
    
  	DossierDTO update(  final DossierDTO dossierDTO ,final long id  );
  	DossierDTO findbyId(final Long id);
    
      
}
