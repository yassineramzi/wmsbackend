package com.wms.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    {
        Map<Integer, String> headers = new HashMap<Integer, String>();
        headers.put( 0, "Identifiant fiscal");
        headers.put( 1, "ICE");
        headers.put( 2, "RIB");
        headers.put( 3, "Designation");
        headers.put( 4, "Activite");
        headers.put( 5, "Adresse");
        headers.put( 6, "Email");
        headers.put( 7, "Registre du commerce");
        headers.put( 8, "Téléphone");
        headers.put( 9, "Ville");
        headers.put( 10, "Banque");
        FILE_HEADERS.putAll(Collections.unmodifiableMap(headers));
    }

    @Override
    protected void createFromRow(final Row row) {
        if (row.getRowNum() != 0) {
            TiersExcelDTO tiersExcelDTO = new TiersExcelDTO();
            try{
                tiersExcelDTO.setIdentifiantFiscal(getValueFromCell(row.getCell(0)));
                tiersExcelDTO.setIce(getValueFromCell(row.getCell(1)));
                tiersExcelDTO.setRib(getValueFromCell(row.getCell(2)));
                tiersExcelDTO.setDesignation(String.valueOf(row.getCell(3).getStringCellValue()));
                tiersExcelDTO.setActivite(String.valueOf(row.getCell(4).getStringCellValue()));
                tiersExcelDTO.setAdresse(String.valueOf(row.getCell(5).getStringCellValue()));
                tiersExcelDTO.setEmail(String.valueOf(row.getCell(6).getStringCellValue()));
                tiersExcelDTO.setRegistreCommerce(getValueFromCell(row.getCell(7)));
                tiersExcelDTO.setTelephone(getValueFromCell(row.getCell(8)));
                tiersExcelDTO.setVille(String.valueOf(row.getCell(9).getStringCellValue()));
                tiersExcelDTO.setBanque(String.valueOf(row.getCell(10).getStringCellValue()));
                this.validLigns.add(tiersExcelDTO);
            } catch(Exception e) {
                log.error("Une erreur est survenue lors du traitement d'une ligne : {}", e.getMessage());
                this.unvalidLigns.add(tiersExcelDTO);
            }
        }
    }

    public void importExcelFile(final MultipartFile file) throws Exception {
        super.importExcelFile(file);
        this.tiersRepository.saveAll(this.tiersExcelMapper.toEntity(validLigns));
    }
    
}
