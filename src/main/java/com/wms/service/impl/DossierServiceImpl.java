package com.wms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.domain.Dossier;
import com.wms.repository.DossierRepository;
import com.wms.service.DossierService;
import com.wms.dto.DossierDTO;
import com.wms.mapper.DossierMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DossierServiceImpl implements DossierService {

    private DossierRepository dossierRepository;

    private DossierMapper dossierMapper;

    @Override
    public DossierDTO create(final DossierDTO dossierDto) {
        Dossier dossier = this.dossierMapper.toEntity(dossierDto);
        return this.dossierMapper.toDto(this.dossierRepository.save(dossier));
    }

    @Override
    public List<DossierDTO> findAll() {
        return this.dossierMapper.toDto(this.dossierRepository.findAll());
    }

    @Override
    public void delete(final Long id){
        this.dossierRepository.deleteById(id);
    }
}
