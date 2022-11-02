package com.wms.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wms.repository.DeviseRepository;
import com.wms.service.ExcelImportService;
import com.wms.service.dto.DeviseExcelDTO;
import com.wms.service.mapper.DeviseExcelMapper;

import lombok.AllArgsConstructor;

@Service("devise")
@AllArgsConstructor
public class DeviseExcelImportServiceImpl extends ExcelImportService<DeviseExcelDTO>{

    private final DeviseExcelMapper deviseExcelMapper;

    private final DeviseRepository deviseRepository;

    static {
        Map<Integer, String> headers = new HashMap<Integer, String>();
        headers.put(0, "designation");
        headers.put(1, "taux");
        FILE_HEADERS.putAll(Collections.unmodifiableMap(headers));
    }

    @Override
    protected void createFromRow(final Row row) {
        if (row.getRowNum() != 0) {
            DeviseExcelDTO deviseExcelDTO = new DeviseExcelDTO();
            try{
                deviseExcelDTO.setDesignation(String.valueOf(row.getCell(0).getStringCellValue()));
                deviseExcelDTO.setTaux((long)row.getCell(1).getNumericCellValue());
                this.validLigns.add(deviseExcelDTO);
            } catch(Exception e) {
                log.error("Une erreur est survenue lors du traitement d'une ligne : {}", e.getMessage());
                this.unvalidLigns.add(deviseExcelDTO);
            }
        }
    }

    public void importExcelFile(final MultipartFile file) throws Exception {
        super.importExcelFile(file);
        this.deviseRepository.saveAll(this.deviseExcelMapper.toEntity(this.validLigns));
    }
    
}
