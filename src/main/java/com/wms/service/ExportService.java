package com.wms.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public interface ExportService {
    void generateExcelFile(HttpServletResponse response, String type) throws IOException ;
}
