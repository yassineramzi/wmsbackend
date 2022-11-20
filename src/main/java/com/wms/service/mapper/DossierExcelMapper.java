package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Dossier;
import com.wms.service.dto.DossierExcelDTO;

@Mapper(componentModel = "spring")
public interface DossierExcelMapper extends EntityMapper<DossierExcelDTO, Dossier>{
    @Override
    DossierExcelDTO toDto(Dossier dossier);

    @Override
    List<DossierExcelDTO> toDto(List<Dossier> dossiers);

    @Override
    Dossier toEntity(DossierExcelDTO dossierExcelDto);

    @Override
    List<Dossier> toEntity(List<DossierExcelDTO> dossiersExcelDto);

    default Dossier fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dossier Dossier = new Dossier();
        Dossier.setId(id);
        return Dossier;
    }
}
