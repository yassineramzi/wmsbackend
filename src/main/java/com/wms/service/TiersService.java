package com.wms.service;

import java.util.List;

import com.wms.service.dto.TiersDTO;

public interface TiersService {
    TiersDTO create(final TiersDTO tiersDTO);
    List<TiersDTO> findAll();
    void delete(final Long id);
}
