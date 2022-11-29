package com.wms.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wms.repository.TvaRepository;
import com.wms.service.ExcelImportService;
import com.wms.service.dto.TvaExcelDTO;
import com.wms.service.mapper.TvaExcelMapper;

import lombok.AllArgsConstructor;

@Service("tva")
@AllArgsConstructor
public class TvaExcelImportServiceImpl extends ExcelImportService<TvaExcelDTO>{

    private final TvaExcelMapper tvaExcelMapper;

    private final TvaRepository tvaRepository;

    {
        Map<Integer, String> headers = new HashMap<Integer, String>();
        headers.put(0, "intitule");
        headers.put(1, "libelle");
        headers.put(2, "codeDeclaration");
        headers.put(3, "taux");
        FILE_HEADERS.putAll(Collections.unmodifiableMap(headers));
    }

    @Override
    protected void createFromRow(final Row row) {
        if (row.getRowNum() != 0) {
            TvaExcelDTO tvaExcelDTO = new TvaExcelDTO();
            try{
                tvaExcelDTO.setIntitule(String.valueOf(row.getCell(0).getStringCellValue()));
                tvaExcelDTO.setLibelle(String.valueOf(row.getCell(1).getStringCellValue()));
                tvaExcelDTO.setCodeDeclaration((long)row.getCell(2).getNumericCellValue());
                tvaExcelDTO.setTaux((long)row.getCell(3).getNumericCellValue());
                this.validLigns.add(tvaExcelDTO);
            } catch(Exception e) {
                log.error("Une erreur est survenue lors du traitement d'une ligne : {}", e.getMessage());
                this.unvalidLigns.add(tvaExcelDTO);
            }
        }
    }

    @Override
    public void importExcelFile(final MultipartFile file) throws Exception {
        super.importExcelFile(file);
        this.tvaRepository.saveAll(this.tvaExcelMapper.toEntity(this.validLigns));
    }
    
}
