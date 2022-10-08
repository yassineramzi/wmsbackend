package com.wms.service.impl;

import java.io.Reader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.wms.service.PersistCsvService;
import com.wms.service.dto.TvaCsvDTO;
@Service("tva")
public class PersistCsvTvaServiceImpl implements PersistCsvService<TvaCsvDTO>{
    private final Logger log = LoggerFactory.getLogger(PersistCsvTvaServiceImpl.class);

    @Override
    public List<TvaCsvDTO> saveCsv(Reader reader) {
        List<TvaCsvDTO> tvaCsvDtoList  = new CsvToBeanBuilder(reader)
            .withType(TvaCsvDTO.class)
            .build()
            .parse();
        log.info(tvaCsvDtoList.toString());
        return tvaCsvDtoList;
    }
    
}
