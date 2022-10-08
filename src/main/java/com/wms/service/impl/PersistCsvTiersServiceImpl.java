package com.wms.service.impl;

import java.io.Reader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.bean.CsvToBeanBuilder;
import com.wms.repository.TiersRepository;
import com.wms.service.PersistCsvService;
import com.wms.service.dto.TiersCsvDTO;
import com.wms.service.mapper.TiersCsvMapper;

public class PersistCsvTiersServiceImpl implements PersistCsvService<TiersCsvDTO> {
    private final Logger log = LoggerFactory.getLogger(PersistCsvTiersServiceImpl.class);

    private final TiersRepository tiersRepository;

    private final TiersCsvMapper tiersCsvMapper;

    @Autowired
    public PersistCsvTiersServiceImpl(
        final TiersRepository tiersRepository,
        final TiersCsvMapper tiersCsvMapper
    ){
        this.tiersRepository = tiersRepository;
        this.tiersCsvMapper = tiersCsvMapper;
    }

    @Override
    public List<TiersCsvDTO> saveCsv(Reader reader) {
        List<TiersCsvDTO> tiersCsvDtoList  = new CsvToBeanBuilder(reader)
            .withType(TiersCsvDTO.class)
            .build()
            .parse();
        log.info(tiersCsvDtoList.toString());
        this.tiersRepository.saveAll(this.tiersCsvMapper.toEntity(tiersCsvDtoList));
        /*
         * TODO : gérer le cas des tiers qui ne correspondent pas aux régles
         *  et les retourner dans un fichier à l'utilisateur
         */ 
        return null;
    }
    
}
