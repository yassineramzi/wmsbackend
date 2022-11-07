package com.wms.service;

import java.util.List;

import com.wms.dto.TvaDTO;

public interface TvaService {

    TvaDTO create(TvaDTO tvaDTO);

    List<TvaDTO> findAll();

    void delete(Long id);
    
}
