package com.wms.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wms.repository.PlanComptableRepository;
import com.wms.service.ExcelImportService;
import com.wms.service.dto.PlanComptableExcelDTO;
import com.wms.service.mapper.PlanComptableExcelMapper;

import lombok.AllArgsConstructor;

@Service("plan-comptable")
@AllArgsConstructor
public class PlanComptableExcelImportServiceImpl extends ExcelImportService<PlanComptableExcelDTO>{

    private final PlanComptableExcelMapper planComptableExcelMapper;

    private final PlanComptableRepository planComptableRepository;

    {
        Map<Integer, String> headers = new HashMap<Integer, String>();
        headers.put( 0, "Numéro de compte");
        headers.put( 1, "Intitulé du compte");
        headers.put( 2, "Débit");
        headers.put( 3, "Type du compte");
        headers.put( 4, "Général");
        FILE_HEADERS.putAll(Collections.unmodifiableMap(headers));
    }

    @Override
    protected void createFromRow(final Row row) {
        if (row.getRowNum() != 0) {
            PlanComptableExcelDTO planComptableExcelDTO = new PlanComptableExcelDTO();
            try{
                planComptableExcelDTO.setNumeroCompte(getValueFromCell(row.getCell(0)));
                planComptableExcelDTO.setIntituleCompte(String.valueOf(row.getCell(1).getStringCellValue()));
                planComptableExcelDTO.setDebit(String.valueOf(row.getCell(2).getStringCellValue()));
                planComptableExcelDTO.setTypeCompte(String.valueOf(row.getCell(3).getStringCellValue()));
                planComptableExcelDTO.setGeneral(String.valueOf(row.getCell(4).getStringCellValue()));
                this.validLigns.add(planComptableExcelDTO);
            } catch(Exception e) {
                log.error("Une erreur est survenue lors du traitement d'une ligne : {}", e.getMessage());
                this.unvalidLigns.add(planComptableExcelDTO);
            }
        }
    }

    public void importExcelFile(final MultipartFile file) throws Exception {
        super.importExcelFile(file);
        this.planComptableRepository.saveAll(this.planComptableExcelMapper.toEntity(validLigns));
    }
    
}
