package com.wms.service.impl;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.wms.repository.TiersRepository;
import com.wms.service.mapper.TiersExcelMapper;
import com.wms.service.PdfExportService;
import com.wms.service.dto.TiersExcelDTO;

import lombok.AllArgsConstructor;

@Service("tiers-pdf-export")
@AllArgsConstructor
public class TiersPdfExportServiceImpl implements PdfExportService {

    private final Set<String> tableHeaders = new LinkedHashSet<>();

    private final TiersRepository tiersRepository;

    private final TiersExcelMapper tiersExcelMapper;

    {
        tableHeaders.add("Denomination");
        tableHeaders.add("Identifiant fiscal");
        tableHeaders.add("Adresse");
        tableHeaders.add("Ville");
        tableHeaders.add("Activite");
        tableHeaders.add("Registre du commerce");
        tableHeaders.add("ICE");
    }

    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {
        List<TiersExcelDTO> data = this.tiersExcelMapper.toDto(this.tiersRepository.findAll());
        Document document = new Document();
        ServletOutputStream outputStream = response.getOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfPTable table = new PdfPTable(7);
        this.addTableHeader(table, this.tableHeaders);
        data.stream().forEach(tiers -> {
            table.addCell(tiers.getDesignation());
            table.addCell(tiers.getIdentifiantFiscal());
            table.addCell(tiers.getAdresse());
            table.addCell(tiers.getVille());
            table.addCell(tiers.getActivite());
            table.addCell(tiers.getRegistreCommerce());
            table.addCell(tiers.getIce());
        });
        document.add(table);
        document.close();
    }
    
}
