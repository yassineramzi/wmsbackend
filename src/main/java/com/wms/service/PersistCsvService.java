package com.wms.service;

import java.io.Reader;
import java.util.List;

public interface PersistCsvService <T> {
    List<T> saveCsv(final Reader reader);
}
