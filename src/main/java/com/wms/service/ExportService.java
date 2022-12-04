package com.wms.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

public interface ExportService {
    void generateFile(HttpServletResponse response, String type) throws IOException, DocumentException ;
}
