package com.wms.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.repository.DossierRepository;
import com.wms.service.ExcelExportService;
import com.wms.service.dto.DossierExcelDTO;
import com.wms.service.mapper.DossierExcelMapper;

@Service("dossier-excel-export")
public class DossierExcelExportServiceImpl extends ExcelExportService<DossierExcelDTO>{

    private DossierRepository dossierRepository;

    private DossierExcelMapper dossierExcelMapper;

    @Autowired
    public DossierExcelExportServiceImpl(final DossierRepository dossierRepository, final DossierExcelMapper dossierExcelMapper) {
        super();
        this.dossierExcelMapper = dossierExcelMapper;
        this.dossierRepository = dossierRepository;
    }

    protected void writeHeader() {
        this.workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Dossier");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Identifiant fiscal", style);
        createCell(row, 1, "ICE", style);
        createCell(row, 2, "Activite", style);
        createCell(row, 3, "Adresse", style);
        createCell(row, 4, "Email", style);
        createCell(row, 5, "Registre du commerce", style);
        createCell(row, 6, "Ville", style);
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
            createCell(row, columnCount++, record.getIdentifiantFiscal(), style);
            createCell(row, columnCount++, record.getIce(), style);
            createCell(row, columnCount++, record.getActivite(), style);
            createCell(row, columnCount++, record.getAdresse(), style);
            createCell(row, columnCount++, record.getEmail(), style);
            createCell(row, columnCount++, record.getRegistreCommerce(), style);
            createCell(row, columnCount++, record.getVille(), style);
        }
    }
    
}
