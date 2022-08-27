package com.wms.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.wms.domain.Associe;
import com.wms.service.dto.AssocieDTO;

@Mapper(componentModel = "spring", uses = {})
public interface AssocieMapper extends EntityMapper<AssocieDTO, Associe>{
    @Override
    AssocieDTO toDto(Associe associe);

    @Override
    List<AssocieDTO> toDto(List<Associe> associes);

    @Override
    Associe toEntity(AssocieDTO associeDto);

    @Override
    List<Associe> toEntity(List<AssocieDTO> associesDto);

    default Associe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Associe Associe = new Associe();
        Associe.setId(id);
        return Associe;
    }
}
