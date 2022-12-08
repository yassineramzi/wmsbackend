package com.wms.service.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wms.repository.DossierRepository;
import com.wms.service.ExcelImportService;
import com.wms.service.dto.DossierExcelDTO;
import com.wms.service.mapper.DossierExcelMapper;

import lombok.AllArgsConstructor;

@Service("dossier")
@AllArgsConstructor
public class DossierExcelImportServiceImpl extends ExcelImportService<DossierExcelDTO>{

    private final DossierExcelMapper dossierExcelMapper;

    private final DossierRepository dossierRepository;

    {
        Map<Integer, String> headers = new HashMap<Integer, String>();
        headers.put( 0, "Denomination");
        headers.put( 1, "Identifiant fiscal");
        headers.put( 2, "Forme juridique");
        headers.put( 3, "Adresse");
        headers.put( 4, "Ville");
        headers.put( 5, "Email");
        headers.put( 6, "Activite");
        headers.put( 7, "Registre commerce");
        headers.put( 8, "ICE");
        FILE_HEADERS.putAll(Collections.unmodifiableMap(headers));
    }

    @Override
    protected void createFromRow(final Row row) {
        if (row.getRowNum() != 0) {
            DossierExcelDTO dossierExcelDTO = new DossierExcelDTO();
            try{
                NumberFormat formatter = new DecimalFormat("#0");
                dossierExcelDTO.setDenomination(String.valueOf(row.getCell(0).getStringCellValue()));                
                dossierExcelDTO.setIdentifiantFiscal(formatter.format(row.getCell(1).getNumericCellValue()));
                dossierExcelDTO.setFormeJuridique(String.valueOf(row.getCell(2).getStringCellValue()));
                dossierExcelDTO.setAdresse(String.valueOf(row.getCell(3).getStringCellValue()));
                dossierExcelDTO.setVille(String.valueOf(row.getCell(4).getStringCellValue()));
                dossierExcelDTO.setEmail(String.valueOf(row.getCell(5).getStringCellValue()));
                dossierExcelDTO.setActivite(String.valueOf(row.getCell(6).getStringCellValue()));
                dossierExcelDTO.setRegistreCommerce(String.valueOf(row.getCell(7).getStringCellValue()));
                dossierExcelDTO.setIce(formatter.format(row.getCell(8).getNumericCellValue()));
                this.validLigns.add(dossierExcelDTO);
            } catch(Exception e) {
                log.error("Une erreur est survenue lors du traitement d'une ligne : {}", e.getMessage());
                this.unvalidLigns.add(dossierExcelDTO);
            }
        }
    }

    public void importExcelFile(final MultipartFile file) throws Exception {
        super.importExcelFile(file);
        this.dossierRepository.saveAll(this.dossierExcelMapper.toEntity(validLigns));
    }
    
}
