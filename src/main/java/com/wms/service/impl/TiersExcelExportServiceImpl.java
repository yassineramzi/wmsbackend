package com.wms.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.repository.TiersRepository;
import com.wms.service.ExcelExportService;
import com.wms.service.dto.TiersExcelDTO;
import com.wms.service.mapper.TiersExcelMapper;

@Service("tiers-excel-export")
public class TiersExcelExportServiceImpl extends ExcelExportService<TiersExcelDTO>{

    private TiersRepository tiersRepository;

    private TiersExcelMapper tiersExcelMapper;

    @Autowired
    public TiersExcelExportServiceImpl(final TiersRepository tiersRepository, final TiersExcelMapper tiersExcelMapper) {
        super();
        this.tiersExcelMapper = tiersExcelMapper;
        this.tiersRepository = tiersRepository;
    }

    protected void writeHeader() {
        sheet = workbook.createSheet("Tiers");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Identifiant fiscal", style);
        createCell(row, 1, "ICE", style);
        createCell(row, 2, "RIB", style);
        createCell(row, 3, "Designation", style);
        createCell(row, 4, "Activite", style);
        createCell(row, 5, "Adresse", style);
        createCell(row, 6, "Email", style);
        createCell(row, 7, "Registre du commerce", style);
        createCell(row, 8, "Téléphone", style);
        createCell(row, 9, "Ville", style);
        createCell(row, 10, "Banque", style);
        createCell(row, 11, "Echeance", style);
        createCell(row, 12, "Type echeance", style);
        createCell(row, 13, "Devise", style);
    }

    protected void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        this.data = this.tiersExcelMapper.toDto(this.tiersRepository.findAll());
        for (TiersExcelDTO record: data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getIdentifiantFiscal(), style);
            createCell(row, columnCount++, record.getIce(), style);
            createCell(row, columnCount++, record.getRib(), style);
            createCell(row, columnCount++, record.getDesignation(), style);
            createCell(row, columnCount++, record.getActivite(), style);
            createCell(row, columnCount++, record.getAdresse(), style);
            createCell(row, columnCount++, record.getEmail(), style);
            createCell(row, columnCount++, record.getRegistreCommerce(), style);
            createCell(row, columnCount++, record.getTelephone(), style);
            createCell(row, columnCount++, record.getVille(), style);
            createCell(row, columnCount++, record.getBanque(), style);
            createCell(row, columnCount++, record.getEcheance(), style);
            createCell(row, columnCount++, record.getTypeEcheance(), style);
            createCell(row, columnCount++, record.getDevise(), style);
        }
    }
    
}
