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
import com.wms.repository.DossierRepository;
import com.wms.service.mapper.DossierExcelMapper;
import com.wms.service.PdfExportService;
import com.wms.service.dto.DossierExcelDTO;

import lombok.AllArgsConstructor;

@Service("dossier-pdf-export")
@AllArgsConstructor
public class DossierPdfExportServiceImpl implements PdfExportService {

    private final Set<String> tableHeaders = new LinkedHashSet<>();

    private final DossierRepository dossierRepository;

    private final DossierExcelMapper dossierExcelMapper;

    {
        tableHeaders.add("Denomination");
        tableHeaders.add("Identifiant fiscal");
        tableHeaders.add("Forme juridique");
        tableHeaders.add("Adresse");
        tableHeaders.add("Ville");
        tableHeaders.add("Activite");
        tableHeaders.add("Registre du commerce");
        tableHeaders.add("ICE");
    }

    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {
        List<DossierExcelDTO> data = this.dossierExcelMapper.toDto(this.dossierRepository.findAll());
        Document document = new Document();
        ServletOutputStream outputStream = response.getOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfPTable table = new PdfPTable(8);
        this.addTableHeader(table, this.tableHeaders);
        data.stream().forEach(dossier -> {
            table.addCell(dossier.getDenomination());
            table.addCell(dossier.getIdentifiantFiscal());
            table.addCell(dossier.getFormeJuridique());
            table.addCell(dossier.getAdresse());
            table.addCell(dossier.getVille());
            table.addCell(dossier.getActivite());
            table.addCell(dossier.getRegistreCommerce());
            table.addCell(dossier.getIce());
        });
        document.add(table);
        document.close();
    }
    
}
