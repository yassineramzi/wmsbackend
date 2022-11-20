package com.wms.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.repository.TvaRepository;
import com.wms.service.ExcelExportService;
import com.wms.service.dto.TvaExcelDTO;
import com.wms.service.mapper.TvaExcelMapper;

@Service("tva-excel-export")
public class TvaExcelExportServiceImpl extends ExcelExportService<TvaExcelDTO>{

    private TvaRepository tvaRepository;

    private TvaExcelMapper tvaExcelMapper;

    @Autowired
    public TvaExcelExportServiceImpl(final TvaRepository tvaRepository, final TvaExcelMapper tvaExcelMapper) {
        super();
        this.tvaExcelMapper = tvaExcelMapper;
        this.tvaRepository = tvaRepository;
    }

    protected void writeHeader() {
        sheet = workbook.createSheet("Tva");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Intitule", style);
        createCell(row, 1, "Libelle", style);
        createCell(row, 2, "Code de déclaration", style);
        createCell(row, 3, "Taux", style);
    }

    protected void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        this.data = this.tvaExcelMapper.toDto(this.tvaRepository.findAll());
        for (TvaExcelDTO record: data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getIntitule(), style);
            createCell(row, columnCount++, record.getLibelle(), style);
            createCell(row, columnCount++, record.getCodeDeclaration(), style);
            createCell(row, columnCount++, record.getTaux(), style);
        }
    }
    
}
