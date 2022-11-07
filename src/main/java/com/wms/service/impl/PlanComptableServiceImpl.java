package com.wms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wms.domain.PlanComptable;
import com.wms.repository.PlanComptableRepository;
import com.wms.service.PlanComptableService;
import com.wms.dto.PlanComptableDTO;
import com.wms.mapper.PlanComptableMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlanComptableServiceImpl  implements PlanComptableService {
    private PlanComptableRepository planComptableRepository;

    private PlanComptableMapper planComptableMapper;

    @Override
    public PlanComptableDTO create(final PlanComptableDTO planComptableDto) {
        PlanComptable planComptable = this.planComptableMapper.toEntity(planComptableDto);
        return this.planComptableMapper.toDto(this.planComptableRepository.save(planComptable));
    }

    @Override
    public List<PlanComptableDTO> findAll() {
        return this.planComptableMapper.toDto(this.planComptableRepository.findAll());
    }

    @Override
    public void delete(final Long id){
        this.planComptableRepository.deleteById(id);
    } 
}
