package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.PlanComptable;
import com.wms.service.dto.PlanComptableExcelDTO;


@Mapper(componentModel = "spring")
public interface PlanComptableExcelMapper extends EntityMapper<PlanComptableExcelDTO, PlanComptable>{
    @Override
    PlanComptableExcelDTO toDto(PlanComptable planComptable);

    @Override
    List<PlanComptableExcelDTO> toDto(List<PlanComptable> planComptable);

    @Override
    PlanComptable toEntity(PlanComptableExcelDTO planComptableExcelDto);

    @Override
    List<PlanComptable> toEntity(List<PlanComptableExcelDTO> planComptableExcelDto);

    default PlanComptable fromId(Long id) {
        if (id == null) {
            return null;
        }
        PlanComptable PlanComptable = new PlanComptable();
        PlanComptable.setId(id);
        return PlanComptable;
    }
}
