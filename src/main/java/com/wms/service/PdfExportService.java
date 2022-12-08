package com.wms.service;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

@FunctionalInterface
public interface PdfExportService {
    
    void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException;

    default void addTableHeader(final PdfPTable table,  final Set<String> tableHeaders) {
        tableHeaders
        .stream()
        .forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }

}
