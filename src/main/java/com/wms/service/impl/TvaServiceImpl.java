package com.wms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.domain.Tva;
import com.wms.repository.TvaRepository;
import com.wms.service.TvaService;
import com.wms.service.dto.TvaDTO;
import com.wms.service.mapper.TvaMapper;

@Service
public class TvaServiceImpl  implements TvaService {
    private TvaRepository tvaRepository;

    private TvaMapper tvaMapper;

    @Override
    public TvaDTO create(final TvaDTO tvaDto) {
        Tva tva = this.tvaMapper.toEntity(tvaDto);
        return this.tvaMapper.toDto(this.tvaRepository.save(tva));
    }

    @Override
    public List<TvaDTO> findAll() {
        return this.tvaMapper.toDto(this.tvaRepository.findAll());
    }

    @Override
    public void delete(final Long id){
        this.tvaRepository.deleteById(id);
    } 
}
