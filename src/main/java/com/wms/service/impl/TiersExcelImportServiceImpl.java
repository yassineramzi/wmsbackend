package com.wms.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wms.repository.TiersRepository;
import com.wms.service.ExcelImportService;
import com.wms.service.dto.TiersExcelDTO;
import com.wms.service.mapper.TiersExcelMapper;

import lombok.AllArgsConstructor;

@Service("tiers")
@AllArgsConstructor
public class TiersExcelImportServiceImpl extends ExcelImportService<TiersExcelDTO>{

    private final TiersExcelMapper tiersExcelMapper;

    private final TiersRepository tiersRepository;

    static {
        Map<Integer, String> headers = new HashMap<Integer, String>();
        headers.put(0, "identifiantFiscal");
        FILE_HEADERS.putAll(Collections.unmodifiableMap(headers));
    }

    @Override
    protected TiersExcelDTO createFromRow(final Row row) {
        if (row.getRowNum() != 0) {
            if (StringUtils.equalsIgnoreCase(row.getCell(0).getStringCellValue(), "FIN") || row.getCell(0).getStringCellValue() == null) {
                return null;
            } else {
                TiersExcelDTO tiersExcelDTO = new TiersExcelDTO();
                tiersExcelDTO.setIdentifiantFiscal(row.getCell(0).getStringCellValue());
                return tiersExcelDTO;
            }
        }
        return null;
    }

    @Override
    protected void addObject(final TiersExcelDTO tiersExcelDTO) {
        this.validLigns.add(tiersExcelDTO);
    }

    public void importExcelFile(final MultipartFile file) throws Exception {
        super.importExcelFile(file);
        this.tiersRepository.saveAll(this.tiersExcelMapper.toEntity(validLigns));
    }
    
}
