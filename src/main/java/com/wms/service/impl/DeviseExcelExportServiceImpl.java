package com.wms.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.repository.DeviseRepository;
import com.wms.service.ExcelExportService;
import com.wms.service.dto.DeviseExcelDTO;
import com.wms.service.mapper.DeviseExcelMapper;

@Service("devise-excel-export")
public class DeviseExcelExportServiceImpl extends ExcelExportService<DeviseExcelDTO>{

    private DeviseRepository deviseRepository;

    private DeviseExcelMapper deviseExcelMapper;

    @Autowired
    public DeviseExcelExportServiceImpl(final DeviseRepository deviseRepository, final DeviseExcelMapper deviseExcelMapper) {
        super();
        this.deviseExcelMapper = deviseExcelMapper;
        this.deviseRepository = deviseRepository;
    }

    protected void writeHeader() {
        sheet = workbook.createSheet("Devise");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Designation", style);
        createCell(row, 1, "Taux", style);
    }

    protected void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        this.data = this.deviseExcelMapper.toDto(this.deviseRepository.findAll());
        for (DeviseExcelDTO record: data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getDesignation(), style);
            createCell(row, columnCount++, record.getTaux(), style);
        }
    }
    
}
