package com.wms.service;

import java.util.List;

import com.wms.service.dto.DeviseDTO;

public interface DeviseService {

    DeviseDTO create(DeviseDTO deviseDTO);

    List<DeviseDTO> findAll();

    void delete(Long id);
    
}
