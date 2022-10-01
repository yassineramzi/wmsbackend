package com.wms.service;

import java.util.List;

import com.wms.service.dto.TvaDTO;

public interface TvaService {

    TvaDTO create(TvaDTO tvaDTO);

    List<TvaDTO> findAll();

    void delete(Long id);
    
}
