package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.PlanComptable;
import com.wms.service.dto.PlanComptableDTO;

@Mapper(componentModel = "spring")
public interface PlanComptableMapper extends EntityMapper<PlanComptableDTO, PlanComptable>{
    @Override
    PlanComptableDTO toDto(PlanComptable planComptable);

    @Override
    List<PlanComptableDTO> toDto(List<PlanComptable> planComptable);

    @Override
    PlanComptable toEntity(PlanComptableDTO planComptableDto);

    @Override
    List<PlanComptable> toEntity(List<PlanComptableDTO> planComptableDto);

    default PlanComptable fromId(Long id) {
        if (id == null) {
            return null;
        }
        PlanComptable PlanComptable = new PlanComptable();
        PlanComptable.setId(id);
        return PlanComptable;
    }
}
