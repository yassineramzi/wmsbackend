package com.wms.mapper;

import com.wms.domain.Journal;
import com.wms.dto.JournalDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JournalMapper extends EntityMapper<JournalDTO, Journal> {
}
