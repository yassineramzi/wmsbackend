package com.wms.service.impl;

import java.io.Reader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.wms.repository.TvaRepository;
import com.wms.service.PersistCsvService;
import com.wms.service.dto.TvaCsvDTO;
import com.wms.service.mapper.TvaCsvMapper;

@Service("tva")
public class PersistCsvTvaServiceImpl implements PersistCsvService<TvaCsvDTO>{
    private final Logger log = LoggerFactory.getLogger(PersistCsvTvaServiceImpl.class);

    private final TvaRepository tvaRepository;

    private final TvaCsvMapper tvaCsvMapper;

    @Autowired
    public PersistCsvTvaServiceImpl(
        final TvaRepository tvaRepository,
        final TvaCsvMapper tvaCsvMapper
    ){
        this.tvaRepository = tvaRepository;
        this.tvaCsvMapper = tvaCsvMapper;
    }

    @Override
    public List<TvaCsvDTO> saveCsv(Reader reader) {
        List<TvaCsvDTO> tvaCsvDtoList  = new CsvToBeanBuilder(reader)
            .withType(TvaCsvDTO.class)
            .build()
            .parse();
        log.info(tvaCsvDtoList.toString());
        this.tvaRepository.saveAll(this.tvaCsvMapper.toEntity(tvaCsvDtoList));
        /*
         * TODO : gérer le cas des tva qui ne correspondent pas aux régles
         *  et les retourner dans un fichier à l'utilisateur
         */ 
        return null;
    }
    
}
