package com.wms.service.impl;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.repository.PlanComptableRepository;
import com.wms.service.ExcelExportService;
import com.wms.service.dto.PlanComptableExcelDTO;
import com.wms.service.mapper.PlanComptableExcelMapper;

@Service("plan-comptable-excel-export")
public class PlanComptableExcelExportServiceImpl extends ExcelExportService<PlanComptableExcelDTO>{

    private PlanComptableRepository planComptableRepository;

    private PlanComptableExcelMapper planComptableExcelMapper;

    @Autowired
    public PlanComptableExcelExportServiceImpl(final PlanComptableRepository planComptableRepository, final PlanComptableExcelMapper planComptableExcelMapper) {
        super();
        this.planComptableExcelMapper = planComptableExcelMapper;
        this.planComptableRepository = planComptableRepository;
    }

    protected void writeHeader() {
        sheet = workbook.createSheet("PlanComptable");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Numéro de compte", style);
        createCell(row, 1, "Intitulé du compte", style);
        createCell(row, 2, "Débit", style);
        createCell(row, 3, "Type du compte", style);
        createCell(row, 4, "Général", style);
    }

    protected void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        this.data = this.planComptableExcelMapper.toDto(this.planComptableRepository.findAll());
        for (PlanComptableExcelDTO record: data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getNumeroCompte(), style);
            createCell(row, columnCount++, record.getIntituleCompte(), style);
            createCell(row, columnCount++, record.getDebit(), style);
            createCell(row, columnCount++, record.getTypeCompte(), style);
            createCell(row, columnCount++, record.getGeneral(), style);
        }
    }
    
}
