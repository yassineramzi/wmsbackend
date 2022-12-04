package com.wms.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.repository.DossierRepository;
import com.wms.service.ExcelExportService;
import com.wms.service.dto.DossierExcelDTO;
import com.wms.service.mapper.DossierExcelMapper;

@Service("dossier-excel-export")
public class DossierExcelExportServiceImpl extends ExcelExportService<DossierExcelDTO>{

    private final DossierRepository dossierRepository;

    private final DossierExcelMapper dossierExcelMapper;

    @Autowired
    public DossierExcelExportServiceImpl(final DossierRepository dossierRepository, final DossierExcelMapper dossierExcelMapper) {
        super();
        this.dossierExcelMapper = dossierExcelMapper;
        this.dossierRepository = dossierRepository;
    }

    protected void writeHeader() {
        sheet = workbook.createSheet("Dossier");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Denomination", style);
        createCell(row, 1, "Identifiant fiscal", style);
        createCell(row, 2, "Forme juridique", style);
        createCell(row, 3, "Adresse", style);
        createCell(row, 4, "Ville", style);
        createCell(row, 5, "Activite", style);
        createCell(row, 6, "Registre du commerce", style);
        createCell(row, 7, "ICE", style);
        
    }

    protected void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        this.data = this.dossierExcelMapper.toDto(this.dossierRepository.findAll());
        for (DossierExcelDTO record: data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getDenomination(), style);
            createCell(row, columnCount++, record.getIdentifiantFiscal(), style);
            createCell(row, columnCount++, record.getFormeJuridique(), style);
            createCell(row, columnCount++, record.getAdresse(), style);
            createCell(row, columnCount++, record.getVille(), style);
            createCell(row, columnCount++, record.getActivite(), style);
            createCell(row, columnCount++, record.getRegistreCommerce(), style);
            createCell(row, columnCount++, record.getIce(), style);
        }
    }
    
}
